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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder;
import fpml.confirmation.InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl;
import fpml.confirmation.InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesImpl;
import fpml.confirmation.InterestLegResetDates;
import fpml.confirmation.meta.InterestLegCalculationPeriodDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Component that holds the various dates used to specify the interest leg of the return swap. It is used to define the InterestPeriodDates identifyer.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestLegCalculationPeriodDates", builder=InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl.class, version="${project.version}")
public interface InterestLegCalculationPeriodDates extends RosettaModelObject {

	InterestLegCalculationPeriodDatesMeta metaData = new InterestLegCalculationPeriodDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the effective date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another effectiveDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another terminationDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 * Specifies the reset dates of the interest leg of the swap.
	 */
	InterestLegResetDates getInterestLegResetDates();
	/**
	 * Specifies the payment dates of the interest leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically point to the payment dates of the equity leg of the swap.
	 */
	AdjustableRelativeOrPeriodicDates2 getInterestLegPaymentDates();
	String getId();

	/*********************** Build Methods  ***********************/
	InterestLegCalculationPeriodDates build();
	
	InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder();
	
	static InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder() {
		return new InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLegCalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestLegCalculationPeriodDates> getType() {
		return InterestLegCalculationPeriodDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("interestLegResetDates"), processor, InterestLegResetDates.class, getInterestLegResetDates());
		processRosetta(path.newSubPath("interestLegPaymentDates"), processor, AdjustableRelativeOrPeriodicDates2.class, getInterestLegPaymentDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegCalculationPeriodDatesBuilder extends InterestLegCalculationPeriodDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		InterestLegResetDates.InterestLegResetDatesBuilder getOrCreateInterestLegResetDates();
		InterestLegResetDates.InterestLegResetDatesBuilder getInterestLegResetDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateInterestLegPaymentDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getInterestLegPaymentDates();
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegResetDates(InterestLegResetDates interestLegResetDates);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegPaymentDates(AdjustableRelativeOrPeriodicDates2 interestLegPaymentDates);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("interestLegResetDates"), processor, InterestLegResetDates.InterestLegResetDatesBuilder.class, getInterestLegResetDates());
			processRosetta(path.newSubPath("interestLegPaymentDates"), processor, AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder.class, getInterestLegPaymentDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLegCalculationPeriodDates  ***********************/
	class InterestLegCalculationPeriodDatesImpl implements InterestLegCalculationPeriodDates {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final InterestLegResetDates interestLegResetDates;
		private final AdjustableRelativeOrPeriodicDates2 interestLegPaymentDates;
		private final String id;
		
		protected InterestLegCalculationPeriodDatesImpl(InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.interestLegResetDates = ofNullable(builder.getInterestLegResetDates()).map(f->f.build()).orElse(null);
			this.interestLegPaymentDates = ofNullable(builder.getInterestLegPaymentDates()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
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
		@RosettaAttribute("interestLegResetDates")
		public InterestLegResetDates getInterestLegResetDates() {
			return interestLegResetDates;
		}
		
		@Override
		@RosettaAttribute("interestLegPaymentDates")
		public AdjustableRelativeOrPeriodicDates2 getInterestLegPaymentDates() {
			return interestLegPaymentDates;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public InterestLegCalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder() {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getInterestLegResetDates()).ifPresent(builder::setInterestLegResetDates);
			ofNullable(getInterestLegPaymentDates()).ifPresent(builder::setInterestLegPaymentDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegCalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(interestLegResetDates, _that.getInterestLegResetDates())) return false;
			if (!Objects.equals(interestLegPaymentDates, _that.getInterestLegPaymentDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (interestLegResetDates != null ? interestLegResetDates.hashCode() : 0);
			_result = 31 * _result + (interestLegPaymentDates != null ? interestLegPaymentDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDates {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"interestLegResetDates=" + this.interestLegResetDates + ", " +
				"interestLegPaymentDates=" + this.interestLegPaymentDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestLegCalculationPeriodDates  ***********************/
	class InterestLegCalculationPeriodDatesBuilderImpl implements InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected InterestLegResetDates.InterestLegResetDatesBuilder interestLegResetDates;
		protected AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder interestLegPaymentDates;
		protected String id;
	
		public InterestLegCalculationPeriodDatesBuilderImpl() {
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
		@RosettaAttribute("interestLegResetDates")
		public InterestLegResetDates.InterestLegResetDatesBuilder getInterestLegResetDates() {
			return interestLegResetDates;
		}
		
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder getOrCreateInterestLegResetDates() {
			InterestLegResetDates.InterestLegResetDatesBuilder result;
			if (interestLegResetDates!=null) {
				result = interestLegResetDates;
			}
			else {
				result = interestLegResetDates = InterestLegResetDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestLegPaymentDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getInterestLegPaymentDates() {
			return interestLegPaymentDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateInterestLegPaymentDates() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder result;
			if (interestLegPaymentDates!=null) {
				result = interestLegPaymentDates;
			}
			else {
				result = interestLegPaymentDates = AdjustableRelativeOrPeriodicDates2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestLegResetDates")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegResetDates(InterestLegResetDates interestLegResetDates) {
			this.interestLegResetDates = interestLegResetDates==null?null:interestLegResetDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestLegPaymentDates")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegPaymentDates(AdjustableRelativeOrPeriodicDates2 interestLegPaymentDates) {
			this.interestLegPaymentDates = interestLegPaymentDates==null?null:interestLegPaymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDates build() {
			return new InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesImpl(this);
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (interestLegResetDates!=null && !interestLegResetDates.prune().hasData()) interestLegResetDates = null;
			if (interestLegPaymentDates!=null && !interestLegPaymentDates.prune().hasData()) interestLegPaymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getInterestLegResetDates()!=null && getInterestLegResetDates().hasData()) return true;
			if (getInterestLegPaymentDates()!=null && getInterestLegPaymentDates().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder o = (InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getInterestLegResetDates(), o.getInterestLegResetDates(), this::setInterestLegResetDates);
			merger.mergeRosetta(getInterestLegPaymentDates(), o.getInterestLegPaymentDates(), this::setInterestLegPaymentDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegCalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(interestLegResetDates, _that.getInterestLegResetDates())) return false;
			if (!Objects.equals(interestLegPaymentDates, _that.getInterestLegPaymentDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (interestLegResetDates != null ? interestLegResetDates.hashCode() : 0);
			_result = 31 * _result + (interestLegPaymentDates != null ? interestLegPaymentDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDatesBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"interestLegResetDates=" + this.interestLegResetDates + ", " +
				"interestLegPaymentDates=" + this.interestLegPaymentDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
