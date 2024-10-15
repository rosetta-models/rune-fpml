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
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.Repayment;
import fpml.confirmation.Repayment.RepaymentBuilder;
import fpml.confirmation.Repayment.RepaymentBuilderImpl;
import fpml.confirmation.Repayment.RepaymentImpl;
import fpml.confirmation.RepaymentTypeModel;
import fpml.confirmation.meta.RepaymentMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a principal repayment being made by the borrower.
 * @version ${project.version}
 */
@RosettaDataType(value="Repayment", builder=Repayment.RepaymentBuilderImpl.class, version="${project.version}")
public interface Repayment extends AbstractLoanContractEvent {

	RepaymentMeta metaData = new RepaymentMeta();

	/*********************** Getter Methods  ***********************/
	MoneyWithParticipantShare getAmount();
	/**
	 * The price at which the repayment occurred. This is usually Par but there could be scenarios where a repayment was made at a discounted level.
	 */
	BigDecimal getPrice();
	RepaymentTypeModel getRepaymentTypeModel();

	/*********************** Build Methods  ***********************/
	Repayment build();
	
	Repayment.RepaymentBuilder toBuilder();
	
	static Repayment.RepaymentBuilder builder() {
		return new Repayment.RepaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Repayment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Repayment> getType() {
		return Repayment.class;
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
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("repaymentTypeModel"), processor, RepaymentTypeModel.class, getRepaymentTypeModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepaymentBuilder extends Repayment, AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		RepaymentTypeModel.RepaymentTypeModelBuilder getOrCreateRepaymentTypeModel();
		RepaymentTypeModel.RepaymentTypeModelBuilder getRepaymentTypeModel();
		Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		Repayment.RepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		Repayment.RepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		Repayment.RepaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		Repayment.RepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		Repayment.RepaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		Repayment.RepaymentBuilder setComment(String comment);
		Repayment.RepaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		Repayment.RepaymentBuilder setEffectiveDate(Date effectiveDate);
		Repayment.RepaymentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		Repayment.RepaymentBuilder setAmount(MoneyWithParticipantShare amount);
		Repayment.RepaymentBuilder setPrice(BigDecimal price);
		Repayment.RepaymentBuilder setRepaymentTypeModel(RepaymentTypeModel repaymentTypeModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("repaymentTypeModel"), processor, RepaymentTypeModel.RepaymentTypeModelBuilder.class, getRepaymentTypeModel());
		}
		

		Repayment.RepaymentBuilder prune();
	}

	/*********************** Immutable Implementation of Repayment  ***********************/
	class RepaymentImpl extends AbstractLoanContractEvent.AbstractLoanContractEventImpl implements Repayment {
		private final MoneyWithParticipantShare amount;
		private final BigDecimal price;
		private final RepaymentTypeModel repaymentTypeModel;
		
		protected RepaymentImpl(Repayment.RepaymentBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.price = builder.getPrice();
			this.repaymentTypeModel = ofNullable(builder.getRepaymentTypeModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("repaymentTypeModel")
		public RepaymentTypeModel getRepaymentTypeModel() {
			return repaymentTypeModel;
		}
		
		@Override
		public Repayment build() {
			return this;
		}
		
		@Override
		public Repayment.RepaymentBuilder toBuilder() {
			Repayment.RepaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Repayment.RepaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getRepaymentTypeModel()).ifPresent(builder::setRepaymentTypeModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(repaymentTypeModel, _that.getRepaymentTypeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (repaymentTypeModel != null ? repaymentTypeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Repayment {" +
				"amount=" + this.amount + ", " +
				"price=" + this.price + ", " +
				"repaymentTypeModel=" + this.repaymentTypeModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Repayment  ***********************/
	class RepaymentBuilderImpl extends AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl  implements Repayment.RepaymentBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		protected BigDecimal price;
		protected RepaymentTypeModel.RepaymentTypeModelBuilder repaymentTypeModel;
	
		public RepaymentBuilderImpl() {
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
		@RosettaAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("repaymentTypeModel")
		public RepaymentTypeModel.RepaymentTypeModelBuilder getRepaymentTypeModel() {
			return repaymentTypeModel;
		}
		
		@Override
		public RepaymentTypeModel.RepaymentTypeModelBuilder getOrCreateRepaymentTypeModel() {
			RepaymentTypeModel.RepaymentTypeModelBuilder result;
			if (repaymentTypeModel!=null) {
				result = repaymentTypeModel;
			}
			else {
				result = repaymentTypeModel = RepaymentTypeModel.builder();
			}
			
			return result;
		}
		
		@Override
		public Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Repayment.RepaymentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Repayment.RepaymentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public Repayment.RepaymentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Repayment.RepaymentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public Repayment.RepaymentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public Repayment.RepaymentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public Repayment.RepaymentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public Repayment.RepaymentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public Repayment.RepaymentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public Repayment.RepaymentBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public Repayment.RepaymentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("price")
		public Repayment.RepaymentBuilder setPrice(BigDecimal price) {
			this.price = price==null?null:price;
			return this;
		}
		@Override
		@RosettaAttribute("repaymentTypeModel")
		public Repayment.RepaymentBuilder setRepaymentTypeModel(RepaymentTypeModel repaymentTypeModel) {
			this.repaymentTypeModel = repaymentTypeModel==null?null:repaymentTypeModel.toBuilder();
			return this;
		}
		
		@Override
		public Repayment build() {
			return new Repayment.RepaymentImpl(this);
		}
		
		@Override
		public Repayment.RepaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repayment.RepaymentBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (repaymentTypeModel!=null && !repaymentTypeModel.prune().hasData()) repaymentTypeModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getPrice()!=null) return true;
			if (getRepaymentTypeModel()!=null && getRepaymentTypeModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repayment.RepaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Repayment.RepaymentBuilder o = (Repayment.RepaymentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getRepaymentTypeModel(), o.getRepaymentTypeModel(), this::setRepaymentTypeModel);
			
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(repaymentTypeModel, _that.getRepaymentTypeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (repaymentTypeModel != null ? repaymentTypeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepaymentBuilder {" +
				"amount=" + this.amount + ", " +
				"price=" + this.price + ", " +
				"repaymentTypeModel=" + this.repaymentTypeModel +
			'}' + " " + super.toString();
		}
	}
}
