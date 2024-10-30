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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder;
import fpml.confirmation.CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilderImpl;
import fpml.confirmation.CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelImpl;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.meta.CommodityBasketOptionFeaturesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the features a commodity basket option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityBasketOptionFeaturesModel", builder=CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityBasketOptionFeaturesModel extends RosettaModelObject {

	CommodityBasketOptionFeaturesModelMeta metaData = new CommodityBasketOptionFeaturesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The effective date of the Commodity Option Transaction. Note that the Termination/Expiration Date should be specified in expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type, as applicable.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of the Commodity Option Transaction. In some confirmations this will be indicated as the second date in &quot;Option Term&quot; or &quot;Term&quot;. Note: If provided, terminationDate should not be before specified expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 * A parametric representation of the Calculation Periods of the Commodity Option Transaction.
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	/**
	 * An absolute representation of the Calculation Period start dates of the Commodity Option Transaction.
	 */
	AdjustableDates getCalculationPeriods();

	/*********************** Build Methods  ***********************/
	CommodityBasketOptionFeaturesModel build();
	
	CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder toBuilder();
	
	static CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder builder() {
		return new CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketOptionFeaturesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketOptionFeaturesModel> getType() {
		return CommodityBasketOptionFeaturesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketOptionFeaturesModelBuilder extends CommodityBasketOptionFeaturesModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
		}
		

		CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketOptionFeaturesModel  ***********************/
	class CommodityBasketOptionFeaturesModelImpl implements CommodityBasketOptionFeaturesModel {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final AdjustableDates calculationPeriods;
		
		protected CommodityBasketOptionFeaturesModelImpl(CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public CommodityBasketOptionFeaturesModel build() {
			return this;
		}
		
		@Override
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder toBuilder() {
			CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketOptionFeaturesModel {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasketOptionFeaturesModel  ***********************/
	class CommodityBasketOptionFeaturesModelBuilderImpl implements CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
	
		public CommodityBasketOptionFeaturesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (calculationPeriodsSchedule!=null) {
				result = calculationPeriodsSchedule;
			}
			else {
				result = calculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		public AdjustableDates.AdjustableDatesBuilder getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationPeriods!=null) {
				result = calculationPeriods;
			}
			else {
				result = calculationPeriods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = calculationPeriodsSchedule==null?null:calculationPeriodsSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationPeriods")
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder setCalculationPeriods(AdjustableDates calculationPeriods) {
			this.calculationPeriods = calculationPeriods==null?null:calculationPeriods.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketOptionFeaturesModel build() {
			return new CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelImpl(this);
		}
		
		@Override
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder o = (CommodityBasketOptionFeaturesModel.CommodityBasketOptionFeaturesModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketOptionFeaturesModelBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods +
			'}';
		}
	}
}
