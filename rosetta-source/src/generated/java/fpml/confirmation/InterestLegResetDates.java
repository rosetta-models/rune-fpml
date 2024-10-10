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
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference;
import fpml.confirmation.InterestLegResetDates;
import fpml.confirmation.InterestLegResetDates.InterestLegResetDatesBuilder;
import fpml.confirmation.InterestLegResetDates.InterestLegResetDatesBuilderImpl;
import fpml.confirmation.InterestLegResetDates.InterestLegResetDatesImpl;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.ResetFrequency;
import fpml.confirmation.ResetRelativeToEnum;
import fpml.confirmation.meta.InterestLegResetDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestLegResetDates", builder=InterestLegResetDates.InterestLegResetDatesBuilderImpl.class, version="${project.version}")
public interface InterestLegResetDates extends RosettaModelObject {

	InterestLegResetDatesMeta metaData = new InterestLegResetDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
	 */
	InterestLegCalculationPeriodDatesReference getCalculationPeriodDatesReference();
	/**
	 * Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
	 */
	ResetRelativeToEnum getResetRelativeTo();
	/**
	 * The frequency at which reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset date is established for each calculation period and some form of rate averaging is applicable.
	 */
	ResetFrequency getResetFrequency();
	/**
	 * Initial fixing date expressed as an offset to another date defined elsewhere in the document.
	 */
	RelativeDateOffset getInitialFixingDate();
	/**
	 * Specifies the fixing date relative to the reset date in terms of a business days offset, or by providing a series of adjustable dates.
	 */
	AdjustableDatesOrRelativeDateOffset getFixingDates();

	/*********************** Build Methods  ***********************/
	InterestLegResetDates build();
	
	InterestLegResetDates.InterestLegResetDatesBuilder toBuilder();
	
	static InterestLegResetDates.InterestLegResetDatesBuilder builder() {
		return new InterestLegResetDates.InterestLegResetDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLegResetDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestLegResetDates> getType() {
		return InterestLegResetDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, InterestLegCalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
		processor.processBasic(path.newSubPath("resetRelativeTo"), ResetRelativeToEnum.class, getResetRelativeTo(), this);
		processRosetta(path.newSubPath("resetFrequency"), processor, ResetFrequency.class, getResetFrequency());
		processRosetta(path.newSubPath("initialFixingDate"), processor, RelativeDateOffset.class, getInitialFixingDate());
		processRosetta(path.newSubPath("fixingDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getFixingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegResetDatesBuilder extends InterestLegResetDates, RosettaModelObjectBuilder {
		InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference();
		InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference();
		ResetFrequency.ResetFrequencyBuilder getOrCreateResetFrequency();
		ResetFrequency.ResetFrequencyBuilder getResetFrequency();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateInitialFixingDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getInitialFixingDate();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreateFixingDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getFixingDates();
		InterestLegResetDates.InterestLegResetDatesBuilder setCalculationPeriodDatesReference(InterestLegCalculationPeriodDatesReference calculationPeriodDatesReference);
		InterestLegResetDates.InterestLegResetDatesBuilder setResetRelativeTo(ResetRelativeToEnum resetRelativeTo);
		InterestLegResetDates.InterestLegResetDatesBuilder setResetFrequency(ResetFrequency resetFrequency);
		InterestLegResetDates.InterestLegResetDatesBuilder setInitialFixingDate(RelativeDateOffset initialFixingDate);
		InterestLegResetDates.InterestLegResetDatesBuilder setFixingDates(AdjustableDatesOrRelativeDateOffset fixingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
			processor.processBasic(path.newSubPath("resetRelativeTo"), ResetRelativeToEnum.class, getResetRelativeTo(), this);
			processRosetta(path.newSubPath("resetFrequency"), processor, ResetFrequency.ResetFrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("initialFixingDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getInitialFixingDate());
			processRosetta(path.newSubPath("fixingDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getFixingDates());
		}
		

		InterestLegResetDates.InterestLegResetDatesBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLegResetDates  ***********************/
	class InterestLegResetDatesImpl implements InterestLegResetDates {
		private final InterestLegCalculationPeriodDatesReference calculationPeriodDatesReference;
		private final ResetRelativeToEnum resetRelativeTo;
		private final ResetFrequency resetFrequency;
		private final RelativeDateOffset initialFixingDate;
		private final AdjustableDatesOrRelativeDateOffset fixingDates;
		
		protected InterestLegResetDatesImpl(InterestLegResetDates.InterestLegResetDatesBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).map(f->f.build()).orElse(null);
			this.resetRelativeTo = builder.getResetRelativeTo();
			this.resetFrequency = ofNullable(builder.getResetFrequency()).map(f->f.build()).orElse(null);
			this.initialFixingDate = ofNullable(builder.getInitialFixingDate()).map(f->f.build()).orElse(null);
			this.fixingDates = ofNullable(builder.getFixingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public InterestLegCalculationPeriodDatesReference getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		@RosettaAttribute("resetRelativeTo")
		public ResetRelativeToEnum getResetRelativeTo() {
			return resetRelativeTo;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		public ResetFrequency getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		public RelativeDateOffset getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingDates")
		public AdjustableDatesOrRelativeDateOffset getFixingDates() {
			return fixingDates;
		}
		
		@Override
		public InterestLegResetDates build() {
			return this;
		}
		
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder toBuilder() {
			InterestLegResetDates.InterestLegResetDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLegResetDates.InterestLegResetDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
			ofNullable(getResetRelativeTo()).ifPresent(builder::setResetRelativeTo);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getInitialFixingDate()).ifPresent(builder::setInitialFixingDate);
			ofNullable(getFixingDates()).ifPresent(builder::setFixingDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegResetDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetRelativeTo, _that.getResetRelativeTo())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(fixingDates, _that.getFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetRelativeTo != null ? resetRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingDates != null ? fixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegResetDates {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetRelativeTo=" + this.resetRelativeTo + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"fixingDates=" + this.fixingDates +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestLegResetDates  ***********************/
	class InterestLegResetDatesBuilderImpl implements InterestLegResetDates.InterestLegResetDatesBuilder {
	
		protected InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder calculationPeriodDatesReference;
		protected ResetRelativeToEnum resetRelativeTo;
		protected ResetFrequency.ResetFrequencyBuilder resetFrequency;
		protected RelativeDateOffset.RelativeDateOffsetBuilder initialFixingDate;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder fixingDates;
	
		public InterestLegResetDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference() {
			InterestLegCalculationPeriodDatesReference.InterestLegCalculationPeriodDatesReferenceBuilder result;
			if (calculationPeriodDatesReference!=null) {
				result = calculationPeriodDatesReference;
			}
			else {
				result = calculationPeriodDatesReference = InterestLegCalculationPeriodDatesReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetRelativeTo")
		public ResetRelativeToEnum getResetRelativeTo() {
			return resetRelativeTo;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		public ResetFrequency.ResetFrequencyBuilder getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public ResetFrequency.ResetFrequencyBuilder getOrCreateResetFrequency() {
			ResetFrequency.ResetFrequencyBuilder result;
			if (resetFrequency!=null) {
				result = resetFrequency;
			}
			else {
				result = resetFrequency = ResetFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialFixingDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getInitialFixingDate() {
			return initialFixingDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateInitialFixingDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (initialFixingDate!=null) {
				result = initialFixingDate;
			}
			else {
				result = initialFixingDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getFixingDates() {
			return fixingDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreateFixingDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (fixingDates!=null) {
				result = fixingDates;
			}
			else {
				result = fixingDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public InterestLegResetDates.InterestLegResetDatesBuilder setCalculationPeriodDatesReference(InterestLegCalculationPeriodDatesReference calculationPeriodDatesReference) {
			this.calculationPeriodDatesReference = calculationPeriodDatesReference==null?null:calculationPeriodDatesReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resetRelativeTo")
		public InterestLegResetDates.InterestLegResetDatesBuilder setResetRelativeTo(ResetRelativeToEnum resetRelativeTo) {
			this.resetRelativeTo = resetRelativeTo==null?null:resetRelativeTo;
			return this;
		}
		@Override
		@RosettaAttribute("resetFrequency")
		public InterestLegResetDates.InterestLegResetDatesBuilder setResetFrequency(ResetFrequency resetFrequency) {
			this.resetFrequency = resetFrequency==null?null:resetFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialFixingDate")
		public InterestLegResetDates.InterestLegResetDatesBuilder setInitialFixingDate(RelativeDateOffset initialFixingDate) {
			this.initialFixingDate = initialFixingDate==null?null:initialFixingDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDates")
		public InterestLegResetDates.InterestLegResetDatesBuilder setFixingDates(AdjustableDatesOrRelativeDateOffset fixingDates) {
			this.fixingDates = fixingDates==null?null:fixingDates.toBuilder();
			return this;
		}
		
		@Override
		public InterestLegResetDates build() {
			return new InterestLegResetDates.InterestLegResetDatesImpl(this);
		}
		
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder prune() {
			if (calculationPeriodDatesReference!=null && !calculationPeriodDatesReference.prune().hasData()) calculationPeriodDatesReference = null;
			if (resetFrequency!=null && !resetFrequency.prune().hasData()) resetFrequency = null;
			if (initialFixingDate!=null && !initialFixingDate.prune().hasData()) initialFixingDate = null;
			if (fixingDates!=null && !fixingDates.prune().hasData()) fixingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().hasData()) return true;
			if (getResetRelativeTo()!=null) return true;
			if (getResetFrequency()!=null && getResetFrequency().hasData()) return true;
			if (getInitialFixingDate()!=null && getInitialFixingDate().hasData()) return true;
			if (getFixingDates()!=null && getFixingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestLegResetDates.InterestLegResetDatesBuilder o = (InterestLegResetDates.InterestLegResetDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::setCalculationPeriodDatesReference);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::setResetFrequency);
			merger.mergeRosetta(getInitialFixingDate(), o.getInitialFixingDate(), this::setInitialFixingDate);
			merger.mergeRosetta(getFixingDates(), o.getFixingDates(), this::setFixingDates);
			
			merger.mergeBasic(getResetRelativeTo(), o.getResetRelativeTo(), this::setResetRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegResetDates _that = getType().cast(o);
		
			if (!Objects.equals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			if (!Objects.equals(resetRelativeTo, _that.getResetRelativeTo())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(initialFixingDate, _that.getInitialFixingDate())) return false;
			if (!Objects.equals(fixingDates, _that.getFixingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			_result = 31 * _result + (resetRelativeTo != null ? resetRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (initialFixingDate != null ? initialFixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingDates != null ? fixingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegResetDatesBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference + ", " +
				"resetRelativeTo=" + this.resetRelativeTo + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"initialFixingDate=" + this.initialFixingDate + ", " +
				"fixingDates=" + this.fixingDates +
			'}';
		}
	}
}
