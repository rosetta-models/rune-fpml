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
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilder;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilderImpl;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventImpl;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LcAdjustment;
import fpml.confirmation.LcAdjustment.LcAdjustmentBuilder;
import fpml.confirmation.LcAdjustment.LcAdjustmentBuilderImpl;
import fpml.confirmation.LcAdjustment.LcAdjustmentImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.LcAdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in the notional amount associated with an outstanding letter of credit.
 * @version ${project.version}
 */
@RosettaDataType(value="LcAdjustment", builder=LcAdjustment.LcAdjustmentBuilderImpl.class, version="${project.version}")
public interface LcAdjustment extends AbstractLcEvent {

	LcAdjustmentMeta metaData = new LcAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the type of adjustment applied - increase or decrease.
	 */
	AdjustmentType getAdjustment();
	/**
	 * The letter of credit amount after the adjustment has been applied.
	 */
	MoneyWithParticipantShare getAmount();
	/**
	 * Set to false for a normal increase or decrease in the letter of credit amount. If set to true, it signifies that a loan borrowing will take place in conjunction with this business event.
	 */
	Boolean getRelatedBorrowing();

	/*********************** Build Methods  ***********************/
	LcAdjustment build();
	
	LcAdjustment.LcAdjustmentBuilder toBuilder();
	
	static LcAdjustment.LcAdjustmentBuilder builder() {
		return new LcAdjustment.LcAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcAdjustment> getType() {
		return LcAdjustment.class;
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
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.class, getAdjustment());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("relatedBorrowing"), Boolean.class, getRelatedBorrowing(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcAdjustmentBuilder extends LcAdjustment, AbstractLcEvent.AbstractLcEventBuilder {
		AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment();
		AdjustmentType.AdjustmentTypeBuilder getAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcAdjustment.LcAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcAdjustment.LcAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcAdjustment.LcAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcAdjustment.LcAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcAdjustment.LcAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcAdjustment.LcAdjustmentBuilder setComment(String comment);
		LcAdjustment.LcAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcAdjustment.LcAdjustmentBuilder setEffectiveDate(Date effectiveDate);
		LcAdjustment.LcAdjustmentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcAdjustment.LcAdjustmentBuilder setAdjustment(AdjustmentType adjustment);
		LcAdjustment.LcAdjustmentBuilder setAmount(MoneyWithParticipantShare amount);
		LcAdjustment.LcAdjustmentBuilder setRelatedBorrowing(Boolean relatedBorrowing);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.AdjustmentTypeBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("relatedBorrowing"), Boolean.class, getRelatedBorrowing(), this);
		}
		

		LcAdjustment.LcAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of LcAdjustment  ***********************/
	class LcAdjustmentImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcAdjustment {
		private final AdjustmentType adjustment;
		private final MoneyWithParticipantShare amount;
		private final Boolean relatedBorrowing;
		
		protected LcAdjustmentImpl(LcAdjustment.LcAdjustmentBuilder builder) {
			super(builder);
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.relatedBorrowing = builder.getRelatedBorrowing();
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("relatedBorrowing")
		public Boolean getRelatedBorrowing() {
			return relatedBorrowing;
		}
		
		@Override
		public LcAdjustment build() {
			return this;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder toBuilder() {
			LcAdjustment.LcAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcAdjustment.LcAdjustmentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getRelatedBorrowing()).ifPresent(builder::setRelatedBorrowing);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(relatedBorrowing, _that.getRelatedBorrowing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (relatedBorrowing != null ? relatedBorrowing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAdjustment {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount + ", " +
				"relatedBorrowing=" + this.relatedBorrowing +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcAdjustment  ***********************/
	class LcAdjustmentBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl  implements LcAdjustment.LcAdjustmentBuilder {
	
		protected AdjustmentType.AdjustmentTypeBuilder adjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected Boolean relatedBorrowing;
	
		public LcAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType.AdjustmentTypeBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment() {
			AdjustmentType.AdjustmentTypeBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = AdjustmentType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedBorrowing")
		public Boolean getRelatedBorrowing() {
			return relatedBorrowing;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcAdjustment.LcAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LcAdjustment.LcAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcAdjustment.LcAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcAdjustment.LcAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcAdjustment.LcAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcAdjustment.LcAdjustmentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcAdjustment.LcAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcAdjustment.LcAdjustmentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LcAdjustment.LcAdjustmentBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public LcAdjustment.LcAdjustmentBuilder setAdjustment(AdjustmentType adjustment) {
			this.adjustment = adjustment==null?null:adjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LcAdjustment.LcAdjustmentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relatedBorrowing")
		public LcAdjustment.LcAdjustmentBuilder setRelatedBorrowing(Boolean relatedBorrowing) {
			this.relatedBorrowing = relatedBorrowing==null?null:relatedBorrowing;
			return this;
		}
		
		@Override
		public LcAdjustment build() {
			return new LcAdjustment.LcAdjustmentImpl(this);
		}
		
		@Override
		public LcAdjustment.LcAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAdjustment.LcAdjustmentBuilder prune() {
			super.prune();
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getRelatedBorrowing()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcAdjustment.LcAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcAdjustment.LcAdjustmentBuilder o = (LcAdjustment.LcAdjustmentBuilder) other;
			
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getRelatedBorrowing(), o.getRelatedBorrowing(), this::setRelatedBorrowing);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(relatedBorrowing, _that.getRelatedBorrowing())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (relatedBorrowing != null ? relatedBorrowing.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcAdjustmentBuilder {" +
				"adjustment=" + this.adjustment + ", " +
				"amount=" + this.amount + ", " +
				"relatedBorrowing=" + this.relatedBorrowing +
			'}' + " " + super.toString();
		}
	}
}
