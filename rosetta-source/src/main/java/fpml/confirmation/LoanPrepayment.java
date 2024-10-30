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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.BreakageFeePayment;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanPrepayment;
import fpml.confirmation.LoanPrepayment.LoanPrepaymentBuilder;
import fpml.confirmation.LoanPrepayment.LoanPrepaymentBuilderImpl;
import fpml.confirmation.LoanPrepayment.LoanPrepaymentImpl;
import fpml.confirmation.Repayment;
import fpml.confirmation.meta.LoanPrepaymentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the prepayment structure associated within a facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanPrepayment", builder=LoanPrepayment.LoanPrepaymentBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanPrepayment extends AbstractFacilityEvent {

	LoanPrepaymentMeta metaData = new LoanPrepaymentMeta();

	/*********************** Getter Methods  ***********************/
	Repayment getRepayment();
	CommitmentAdjustment getCommitmentAdjustment();
	BreakageFeePayment getBreakageFeePayment();

	/*********************** Build Methods  ***********************/
	LoanPrepayment build();
	
	LoanPrepayment.LoanPrepaymentBuilder toBuilder();
	
	static LoanPrepayment.LoanPrepaymentBuilder builder() {
		return new LoanPrepayment.LoanPrepaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanPrepayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanPrepayment> getType() {
		return LoanPrepayment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("repayment"), processor, Repayment.class, getRepayment());
		processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.class, getCommitmentAdjustment());
		processRosetta(path.newSubPath("breakageFeePayment"), processor, BreakageFeePayment.class, getBreakageFeePayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanPrepaymentBuilder extends LoanPrepayment, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		Repayment.RepaymentBuilder getOrCreateRepayment();
		Repayment.RepaymentBuilder getRepayment();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment();
		CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment();
		BreakageFeePayment.BreakageFeePaymentBuilder getOrCreateBreakageFeePayment();
		BreakageFeePayment.BreakageFeePaymentBuilder getBreakageFeePayment();
		LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanPrepayment.LoanPrepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanPrepayment.LoanPrepaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanPrepayment.LoanPrepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanPrepayment.LoanPrepaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanPrepayment.LoanPrepaymentBuilder setComment(String comment);
		LoanPrepayment.LoanPrepaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LoanPrepayment.LoanPrepaymentBuilder setEffectiveDate(Date effectiveDate);
		LoanPrepayment.LoanPrepaymentBuilder setFacilityReference(FacilityReference facilityReference);
		LoanPrepayment.LoanPrepaymentBuilder setRepayment(Repayment repayment);
		LoanPrepayment.LoanPrepaymentBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment);
		LoanPrepayment.LoanPrepaymentBuilder setBreakageFeePayment(BreakageFeePayment breakageFeePayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("repayment"), processor, Repayment.RepaymentBuilder.class, getRepayment());
			processRosetta(path.newSubPath("commitmentAdjustment"), processor, CommitmentAdjustment.CommitmentAdjustmentBuilder.class, getCommitmentAdjustment());
			processRosetta(path.newSubPath("breakageFeePayment"), processor, BreakageFeePayment.BreakageFeePaymentBuilder.class, getBreakageFeePayment());
		}
		

		LoanPrepayment.LoanPrepaymentBuilder prune();
	}

	/*********************** Immutable Implementation of LoanPrepayment  ***********************/
	class LoanPrepaymentImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements LoanPrepayment {
		private final Repayment repayment;
		private final CommitmentAdjustment commitmentAdjustment;
		private final BreakageFeePayment breakageFeePayment;
		
		protected LoanPrepaymentImpl(LoanPrepayment.LoanPrepaymentBuilder builder) {
			super(builder);
			this.repayment = ofNullable(builder.getRepayment()).map(f->f.build()).orElse(null);
			this.commitmentAdjustment = ofNullable(builder.getCommitmentAdjustment()).map(f->f.build()).orElse(null);
			this.breakageFeePayment = ofNullable(builder.getBreakageFeePayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("repayment")
		public Repayment getRepayment() {
			return repayment;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		@RosettaAttribute("breakageFeePayment")
		public BreakageFeePayment getBreakageFeePayment() {
			return breakageFeePayment;
		}
		
		@Override
		public LoanPrepayment build() {
			return this;
		}
		
		@Override
		public LoanPrepayment.LoanPrepaymentBuilder toBuilder() {
			LoanPrepayment.LoanPrepaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanPrepayment.LoanPrepaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRepayment()).ifPresent(builder::setRepayment);
			ofNullable(getCommitmentAdjustment()).ifPresent(builder::setCommitmentAdjustment);
			ofNullable(getBreakageFeePayment()).ifPresent(builder::setBreakageFeePayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPrepayment _that = getType().cast(o);
		
			if (!Objects.equals(repayment, _that.getRepayment())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			if (!Objects.equals(breakageFeePayment, _that.getBreakageFeePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repayment != null ? repayment.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			_result = 31 * _result + (breakageFeePayment != null ? breakageFeePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPrepayment {" +
				"repayment=" + this.repayment + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment + ", " +
				"breakageFeePayment=" + this.breakageFeePayment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanPrepayment  ***********************/
	class LoanPrepaymentBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements LoanPrepayment.LoanPrepaymentBuilder {
	
		protected Repayment.RepaymentBuilder repayment;
		protected CommitmentAdjustment.CommitmentAdjustmentBuilder commitmentAdjustment;
		protected BreakageFeePayment.BreakageFeePaymentBuilder breakageFeePayment;
	
		public LoanPrepaymentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("repayment")
		public Repayment.RepaymentBuilder getRepayment() {
			return repayment;
		}
		
		@Override
		public Repayment.RepaymentBuilder getOrCreateRepayment() {
			Repayment.RepaymentBuilder result;
			if (repayment!=null) {
				result = repayment;
			}
			else {
				result = repayment = Repayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getCommitmentAdjustment() {
			return commitmentAdjustment;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder getOrCreateCommitmentAdjustment() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder result;
			if (commitmentAdjustment!=null) {
				result = commitmentAdjustment;
			}
			else {
				result = commitmentAdjustment = CommitmentAdjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("breakageFeePayment")
		public BreakageFeePayment.BreakageFeePaymentBuilder getBreakageFeePayment() {
			return breakageFeePayment;
		}
		
		@Override
		public BreakageFeePayment.BreakageFeePaymentBuilder getOrCreateBreakageFeePayment() {
			BreakageFeePayment.BreakageFeePaymentBuilder result;
			if (breakageFeePayment!=null) {
				result = breakageFeePayment;
			}
			else {
				result = breakageFeePayment = BreakageFeePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanPrepayment.LoanPrepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanPrepayment.LoanPrepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public LoanPrepayment.LoanPrepaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanPrepayment.LoanPrepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanPrepayment.LoanPrepaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanPrepayment.LoanPrepaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LoanPrepayment.LoanPrepaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LoanPrepayment.LoanPrepaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public LoanPrepayment.LoanPrepaymentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("repayment")
		public LoanPrepayment.LoanPrepaymentBuilder setRepayment(Repayment repayment) {
			this.repayment = repayment==null?null:repayment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commitmentAdjustment")
		public LoanPrepayment.LoanPrepaymentBuilder setCommitmentAdjustment(CommitmentAdjustment commitmentAdjustment) {
			this.commitmentAdjustment = commitmentAdjustment==null?null:commitmentAdjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("breakageFeePayment")
		public LoanPrepayment.LoanPrepaymentBuilder setBreakageFeePayment(BreakageFeePayment breakageFeePayment) {
			this.breakageFeePayment = breakageFeePayment==null?null:breakageFeePayment.toBuilder();
			return this;
		}
		
		@Override
		public LoanPrepayment build() {
			return new LoanPrepayment.LoanPrepaymentImpl(this);
		}
		
		@Override
		public LoanPrepayment.LoanPrepaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPrepayment.LoanPrepaymentBuilder prune() {
			super.prune();
			if (repayment!=null && !repayment.prune().hasData()) repayment = null;
			if (commitmentAdjustment!=null && !commitmentAdjustment.prune().hasData()) commitmentAdjustment = null;
			if (breakageFeePayment!=null && !breakageFeePayment.prune().hasData()) breakageFeePayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRepayment()!=null && getRepayment().hasData()) return true;
			if (getCommitmentAdjustment()!=null && getCommitmentAdjustment().hasData()) return true;
			if (getBreakageFeePayment()!=null && getBreakageFeePayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPrepayment.LoanPrepaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanPrepayment.LoanPrepaymentBuilder o = (LoanPrepayment.LoanPrepaymentBuilder) other;
			
			merger.mergeRosetta(getRepayment(), o.getRepayment(), this::setRepayment);
			merger.mergeRosetta(getCommitmentAdjustment(), o.getCommitmentAdjustment(), this::setCommitmentAdjustment);
			merger.mergeRosetta(getBreakageFeePayment(), o.getBreakageFeePayment(), this::setBreakageFeePayment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPrepayment _that = getType().cast(o);
		
			if (!Objects.equals(repayment, _that.getRepayment())) return false;
			if (!Objects.equals(commitmentAdjustment, _that.getCommitmentAdjustment())) return false;
			if (!Objects.equals(breakageFeePayment, _that.getBreakageFeePayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (repayment != null ? repayment.hashCode() : 0);
			_result = 31 * _result + (commitmentAdjustment != null ? commitmentAdjustment.hashCode() : 0);
			_result = 31 * _result + (breakageFeePayment != null ? breakageFeePayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPrepaymentBuilder {" +
				"repayment=" + this.repayment + ", " +
				"commitmentAdjustment=" + this.commitmentAdjustment + ", " +
				"breakageFeePayment=" + this.breakageFeePayment +
			'}' + " " + super.toString();
		}
	}
}
