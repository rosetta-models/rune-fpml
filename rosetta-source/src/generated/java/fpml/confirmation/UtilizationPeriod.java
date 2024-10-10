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
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.UtilizationAmounts;
import fpml.confirmation.UtilizationPeriod;
import fpml.confirmation.UtilizationPeriod.UtilizationPeriodBuilder;
import fpml.confirmation.UtilizationPeriod.UtilizationPeriodBuilderImpl;
import fpml.confirmation.UtilizationPeriod.UtilizationPeriodImpl;
import fpml.confirmation.meta.UtilizationPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A schedule that incorporates all sub-periods of an interest accrual calculation.
 * @version ${project.version}
 */
@RosettaDataType(value="UtilizationPeriod", builder=UtilizationPeriod.UtilizationPeriodBuilderImpl.class, version="${project.version}")
public interface UtilizationPeriod extends RosettaModelObject {

	UtilizationPeriodMeta metaData = new UtilizationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	PeriodWithDaysModel getPeriodWithDaysModel();
	/**
	 * The funded and unfunded utilization details.
	 */
	UtilizationAmounts getUtilizationAmounts();

	/*********************** Build Methods  ***********************/
	UtilizationPeriod build();
	
	UtilizationPeriod.UtilizationPeriodBuilder toBuilder();
	
	static UtilizationPeriod.UtilizationPeriodBuilder builder() {
		return new UtilizationPeriod.UtilizationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UtilizationPeriod> getType() {
		return UtilizationPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.class, getPeriodWithDaysModel());
		processRosetta(path.newSubPath("utilizationAmounts"), processor, UtilizationAmounts.class, getUtilizationAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationPeriodBuilder extends UtilizationPeriod, RosettaModelObjectBuilder {
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel();
		PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel();
		UtilizationAmounts.UtilizationAmountsBuilder getOrCreateUtilizationAmounts();
		UtilizationAmounts.UtilizationAmountsBuilder getUtilizationAmounts();
		UtilizationPeriod.UtilizationPeriodBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel);
		UtilizationPeriod.UtilizationPeriodBuilder setUtilizationAmounts(UtilizationAmounts utilizationAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodWithDaysModel"), processor, PeriodWithDaysModel.PeriodWithDaysModelBuilder.class, getPeriodWithDaysModel());
			processRosetta(path.newSubPath("utilizationAmounts"), processor, UtilizationAmounts.UtilizationAmountsBuilder.class, getUtilizationAmounts());
		}
		

		UtilizationPeriod.UtilizationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of UtilizationPeriod  ***********************/
	class UtilizationPeriodImpl implements UtilizationPeriod {
		private final PeriodWithDaysModel periodWithDaysModel;
		private final UtilizationAmounts utilizationAmounts;
		
		protected UtilizationPeriodImpl(UtilizationPeriod.UtilizationPeriodBuilder builder) {
			this.periodWithDaysModel = ofNullable(builder.getPeriodWithDaysModel()).map(f->f.build()).orElse(null);
			this.utilizationAmounts = ofNullable(builder.getUtilizationAmounts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		@RosettaAttribute("utilizationAmounts")
		public UtilizationAmounts getUtilizationAmounts() {
			return utilizationAmounts;
		}
		
		@Override
		public UtilizationPeriod build() {
			return this;
		}
		
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder toBuilder() {
			UtilizationPeriod.UtilizationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationPeriod.UtilizationPeriodBuilder builder) {
			ofNullable(getPeriodWithDaysModel()).ifPresent(builder::setPeriodWithDaysModel);
			ofNullable(getUtilizationAmounts()).ifPresent(builder::setUtilizationAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(utilizationAmounts, _that.getUtilizationAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (utilizationAmounts != null ? utilizationAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationPeriod {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"utilizationAmounts=" + this.utilizationAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationPeriod  ***********************/
	class UtilizationPeriodBuilderImpl implements UtilizationPeriod.UtilizationPeriodBuilder {
	
		protected PeriodWithDaysModel.PeriodWithDaysModelBuilder periodWithDaysModel;
		protected UtilizationAmounts.UtilizationAmountsBuilder utilizationAmounts;
	
		public UtilizationPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder getPeriodWithDaysModel() {
			return periodWithDaysModel;
		}
		
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder getOrCreatePeriodWithDaysModel() {
			PeriodWithDaysModel.PeriodWithDaysModelBuilder result;
			if (periodWithDaysModel!=null) {
				result = periodWithDaysModel;
			}
			else {
				result = periodWithDaysModel = PeriodWithDaysModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("utilizationAmounts")
		public UtilizationAmounts.UtilizationAmountsBuilder getUtilizationAmounts() {
			return utilizationAmounts;
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder getOrCreateUtilizationAmounts() {
			UtilizationAmounts.UtilizationAmountsBuilder result;
			if (utilizationAmounts!=null) {
				result = utilizationAmounts;
			}
			else {
				result = utilizationAmounts = UtilizationAmounts.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodWithDaysModel")
		public UtilizationPeriod.UtilizationPeriodBuilder setPeriodWithDaysModel(PeriodWithDaysModel periodWithDaysModel) {
			this.periodWithDaysModel = periodWithDaysModel==null?null:periodWithDaysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("utilizationAmounts")
		public UtilizationPeriod.UtilizationPeriodBuilder setUtilizationAmounts(UtilizationAmounts utilizationAmounts) {
			this.utilizationAmounts = utilizationAmounts==null?null:utilizationAmounts.toBuilder();
			return this;
		}
		
		@Override
		public UtilizationPeriod build() {
			return new UtilizationPeriod.UtilizationPeriodImpl(this);
		}
		
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder prune() {
			if (periodWithDaysModel!=null && !periodWithDaysModel.prune().hasData()) periodWithDaysModel = null;
			if (utilizationAmounts!=null && !utilizationAmounts.prune().hasData()) utilizationAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodWithDaysModel()!=null && getPeriodWithDaysModel().hasData()) return true;
			if (getUtilizationAmounts()!=null && getUtilizationAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationPeriod.UtilizationPeriodBuilder o = (UtilizationPeriod.UtilizationPeriodBuilder) other;
			
			merger.mergeRosetta(getPeriodWithDaysModel(), o.getPeriodWithDaysModel(), this::setPeriodWithDaysModel);
			merger.mergeRosetta(getUtilizationAmounts(), o.getUtilizationAmounts(), this::setUtilizationAmounts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodWithDaysModel, _that.getPeriodWithDaysModel())) return false;
			if (!Objects.equals(utilizationAmounts, _that.getUtilizationAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodWithDaysModel != null ? periodWithDaysModel.hashCode() : 0);
			_result = 31 * _result + (utilizationAmounts != null ? utilizationAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationPeriodBuilder {" +
				"periodWithDaysModel=" + this.periodWithDaysModel + ", " +
				"utilizationAmounts=" + this.utilizationAmounts +
			'}';
		}
	}
}
