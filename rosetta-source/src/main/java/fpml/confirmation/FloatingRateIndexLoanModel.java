package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FloatingRateIndexLoan;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder;
import fpml.confirmation.FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilderImpl;
import fpml.confirmation.FloatingRateIndexLoanModel.FloatingRateIndexLoanModelImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FloatingRateIndexLoanModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which captures the index and tenor associated with the floating rate. We are referring to a loan-specific floating rate scheme.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FloatingRateIndexLoanModel", builder=FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FloatingRateIndexLoanModel extends RosettaModelObject {

	FloatingRateIndexLoanModelMeta metaData = new FloatingRateIndexLoanModelMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexLoan getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexLoanModel build();
	
	FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder toBuilder();
	
	static FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder builder() {
		return new FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexLoanModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateIndexLoanModel> getType() {
		return FloatingRateIndexLoanModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndexLoan.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexLoanModelBuilder extends FloatingRateIndexLoanModel, RosettaModelObjectBuilder {
		FloatingRateIndexLoan.FloatingRateIndexLoanBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndexLoan.FloatingRateIndexLoanBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder setFloatingRateIndex(FloatingRateIndexLoan floatingRateIndex);
		FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndexLoan.FloatingRateIndexLoanBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexLoanModel  ***********************/
	class FloatingRateIndexLoanModelImpl implements FloatingRateIndexLoanModel {
		private final FloatingRateIndexLoan floatingRateIndex;
		private final Period indexTenor;
		
		protected FloatingRateIndexLoanModelImpl(FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndexLoan getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public FloatingRateIndexLoanModel build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder toBuilder() {
			FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexLoanModel _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexLoanModel {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexLoanModel  ***********************/
	class FloatingRateIndexLoanModelBuilderImpl implements FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder {
	
		protected FloatingRateIndexLoan.FloatingRateIndexLoanBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public FloatingRateIndexLoanModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndexLoan.FloatingRateIndexLoanBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndexLoan.FloatingRateIndexLoanBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndexLoan.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder setFloatingRateIndex(FloatingRateIndexLoan floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexTenor")
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexLoanModel build() {
			return new FloatingRateIndexLoanModel.FloatingRateIndexLoanModelImpl(this);
		}
		
		@Override
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder o = (FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexLoanModel _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexLoanModelBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}
