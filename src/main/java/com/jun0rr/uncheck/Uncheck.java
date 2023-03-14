/*
 * Direitos Autorais Reservados (c) 2011 Juno Roesler
 * Contato: juno.rr@gmail.com
 * 
 * Esta biblioteca é software livre; você pode redistribuí-la e/ou modificá-la sob os
 * termos da Licença Pública Geral Menor do GNU conforme publicada pela Free
 * Software Foundation; tanto a versão 2.1 da Licença, ou qualquer
 * versão posterior.
 * 
 * Esta biblioteca é distribuída na expectativa de que seja útil, porém, SEM
 * NENHUMA GARANTIA; nem mesmo a garantia implícita de COMERCIABILIDADE
 * OU ADEQUAÇÃO A UMA FINALIDADE ESPECÍFICA. Consulte a Licença Pública
 * Geral Menor do GNU para mais detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral Menor do GNU junto
 * com esta biblioteca; se não, acesse 
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html, 
 * ou escreva para a Free Software Foundation, Inc., no
 * endereço 59 Temple Street, Suite 330, Boston, MA 02111-1307 USA.
 */

package com.jun0rr.uncheck;

/**
 *
 * @author Juno Roesler - juno.rr@gmail.com
 * @version 0.1 - 2022-01-26
 */
public class Uncheck {

    /**
     * throws {@code throwable} as call exception, without wrapping exception.
     *
     * @return will never return anything, return type is set to {@code exception} only to be able to write <code>throw call(exception)</code>
     * @throws T {@code throwable} as call exception
     */
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> T uncheck(Throwable throwable) throws T {
        throw (T) throwable;
    }
    
    
    @FunctionalInterface
    public interface ThrowableSupplier<R> {
        R get() throws Throwable;
    }

    /**
     * Executes given function, catches and rethrows checked exceptions as RuntimeException.
     * @return return of supplier.
     * @see #uncheck(Throwable)
     */
    public static <R> R call(ThrowableSupplier<R> supplier) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            throw Uncheck.<RuntimeException>uncheck(e);
        }
    }


    @FunctionalInterface
    public interface ThrowableRunner {
        void run() throws Throwable;
    }

    /**
     * Executes given runnable, catches and rethrows checked exceptions as RuntimeException.
     * @see #uncheck(Throwable)
     */
    public static void call(ThrowableRunner runner) {
        try {
            runner.run();
        } catch (Throwable e) {
            throw Uncheck.<RuntimeException>uncheck(e);
        }
    }

}