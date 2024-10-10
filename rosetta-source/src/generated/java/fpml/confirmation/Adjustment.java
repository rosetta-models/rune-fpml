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
import fpml.confirmation.Adjustment;
import fpml.confirmation.Adjustment.AdjustmentBuilder;
import fpml.confirmation.Adjustment.AdjustmentBuilderImpl;
import fpml.confirmation.Adjustment.AdjustmentImpl;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractAdjustment;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentBuilder;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentBuilderImpl;
import fpml.confirmation.LoanContractAdjustment.LoanContractAdjustmentImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.AdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="Adjustment", builder=Adjustment.AdjustmentBuilderImpl.class, version="${project.version}")
public interface Adjustment extends LoanContractAdjustment {

	AdjustmentMeta metaData = new AdjustmentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Adjustment build();
	
	Adjustment.AdjustmentBuilder toBuilder();
	
	static Adjustment.AdjustmentBuilder builder() {
		return new Adjustment.AdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Adjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Adjustment> getType() {
		return Adjustment.class;
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
		processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.class, getAdjustment());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustmentBuilder extends Adjustment, LoanContractAdjustment.LoanContractAdjustmentBuilder {
		Adjustment.AdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		Adjustment.AdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		Adjustment.AdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		Adjustment.AdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		Adjustment.AdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		Adjustment.AdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		Adjustment.AdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		Adjustment.AdjustmentBuilder setComment(String comment);
		Adjustment.AdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		Adjustment.AdjustmentBuilder setEffectiveDate(Date effectiveDate);
		Adjustment.AdjustmentBuilder setLoanContractReference(LoanContractReference loanContractReference);
		Adjustment.AdjustmentBuilder setAdjustment(AdjustmentType adjustment);
		Adjustment.AdjustmentBuilder setAmount(MoneyWithParticipantShare amount);

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
			processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.AdjustmentTypeBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		Adjustment.AdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of Adjustment  ***********************/
	class AdjustmentImpl extends LoanContractAdjustment.LoanContractAdjustmentImpl implements Adjustment {
		
		protected AdjustmentImpl(Adjustment.AdjustmentBuilder builder) {
			super(builder);
		}
		
		@Override
		public Adjustment build() {
			return this;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder toBuilder() {
			Adjustment.AdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Adjustment.AdjustmentBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Adjustment {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Adjustment  ***********************/
	class AdjustmentBuilderImpl extends LoanContractAdjustment.LoanContractAdjustmentBuilderImpl  implements Adjustment.AdjustmentBuilder {
	
	
		public AdjustmentBuilderImpl() {
		}
	
		@Override
		public Adjustment.AdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Adjustment.AdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public Adjustment.AdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Adjustment.AdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public Adjustment.AdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public Adjustment.AdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public Adjustment.AdjustmentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public Adjustment.AdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public Adjustment.AdjustmentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public Adjustment.AdjustmentBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public Adjustment.AdjustmentBuilder setAdjustment(AdjustmentType adjustment) {
			this.adjustment = adjustment==null?null:adjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public Adjustment.AdjustmentBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public Adjustment build() {
			return new Adjustment.AdjustmentImpl(this);
		}
		
		@Override
		public Adjustment.AdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Adjustment.AdjustmentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Adjustment.AdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Adjustment.AdjustmentBuilder o = (Adjustment.AdjustmentBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustmentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
