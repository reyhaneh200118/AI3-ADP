package aufgabe3.ad_2;

import aufgabe3.ad_2_1.Insertion;
import aufgabe3.ad_2_1.Selection;
import aufgabe3.ad_2_1.Shell;
import aufgabe3.ad_2_2.Merge;
import aufgabe3.ad_2_2.MergeBottomUp;
import aufgabe3.ad_2_3.Quick;
import aufgabe3.ad_2_3.Quick3Way;
import aufgabe3.ad_2_3.Quick3WayPlusInsertion;
import aufgabe3.ad_2_3.QuickPlusInsertion;
import aufgabe3.ad_2_4.HeapSort;

public enum Sorter {
    SELECTION {
        @Override
        public Class<?> getSorterClass() {
            return Selection.class;
        }
    }, INSERTION {
        @Override
        public Class<?> getSorterClass() { return Insertion.class;}
    }, SHELL {
        @Override
        public Class<?> getSorterClass() {return Shell.class;}
    }, MERGE {
        @Override
        public Class<?> getSorterClass() { return Merge.class; }
    }, MERGEBU {
        @Override
        public Class<?> getSorterClass() {
            return MergeBottomUp.class;
        }
    }, QUICK {
        @Override
        public Class<?> getSorterClass() {
            return Quick.class;
        }
    },QUICKINSERTION {
        @Override
        public Class<?> getSorterClass() {
            return QuickPlusInsertion.class;
        }
    }, QUICK3WAY {
        @Override
        public Class<?> getSorterClass() {
            return Quick3Way.class;
        }
    },
    QUICK3WAYINSERTION {
        @Override
        public Class<?> getSorterClass() {
            return Quick3WayPlusInsertion.class;
        }
    }, HEAP {
        @Override
        public Class<?> getSorterClass() {
            return HeapSort.class;
        }
    };

    public abstract Class<?> getSorterClass();
}
