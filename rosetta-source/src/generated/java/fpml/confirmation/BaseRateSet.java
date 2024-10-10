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
import fpml.confirmation.BaseRateSet;
import fpml.confirmation.BaseRateSet.BaseRateSetBuilder;
import fpml.confirmation.BaseRateSet.BaseRateSetBuilderImpl;
import fpml.confirmation.BaseRateSet.BaseRateSetImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetBuilder;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl;
import fpml.confirmation.LoanContractBaseRateSet.LoanContractBaseRateSetImpl;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.BaseRateSetMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="BaseRateSet", builder=BaseRateSet.BaseRateSetBuilderImpl.class, version="${project.version}")
public interface BaseRateSet extends LoanContractBaseRateSet {

	BaseRateSetMeta metaData = new BaseRateSetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	BaseRateSet build();
	
	BaseRateSet.BaseRateSetBuilder toBuilder();
	
	static BaseRateSet.BaseRateSetBuilder builder() {
		return new BaseRateSet.BaseRateSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BaseRateSet> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BaseRateSet> getType() {
		return BaseRateSet.class;
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
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BaseRateSetBuilder extends BaseRateSet, LoanContractBaseRateSet.LoanContractBaseRateSetBuilder {
		BaseRateSet.BaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		BaseRateSet.BaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		BaseRateSet.BaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		BaseRateSet.BaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		BaseRateSet.BaseRateSetBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		BaseRateSet.BaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		BaseRateSet.BaseRateSetBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		BaseRateSet.BaseRateSetBuilder setComment(String comment);
		BaseRateSet.BaseRateSetBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		BaseRateSet.BaseRateSetBuilder setEffectiveDate(Date effectiveDate);
		BaseRateSet.BaseRateSetBuilder setLoanContractReference(LoanContractReference loanContractReference);
		BaseRateSet.BaseRateSetBuilder setFixingDate(Date fixingDate);
		BaseRateSet.BaseRateSetBuilder setRate(BigDecimal rate);

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
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		BaseRateSet.BaseRateSetBuilder prune();
	}

	/*********************** Immutable Implementation of BaseRateSet  ***********************/
	class BaseRateSetImpl extends LoanContractBaseRateSet.LoanContractBaseRateSetImpl implements BaseRateSet {
		
		protected BaseRateSetImpl(BaseRateSet.BaseRateSetBuilder builder) {
			super(builder);
		}
		
		@Override
		public BaseRateSet build() {
			return this;
		}
		
		@Override
		public BaseRateSet.BaseRateSetBuilder toBuilder() {
			BaseRateSet.BaseRateSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BaseRateSet.BaseRateSetBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "BaseRateSet {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BaseRateSet  ***********************/
	class BaseRateSetBuilderImpl extends LoanContractBaseRateSet.LoanContractBaseRateSetBuilderImpl  implements BaseRateSet.BaseRateSetBuilder {
	
	
		public BaseRateSetBuilderImpl() {
		}
	
		@Override
		public BaseRateSet.BaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public BaseRateSet.BaseRateSetBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public BaseRateSet.BaseRateSetBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public BaseRateSet.BaseRateSetBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BaseRateSet.BaseRateSetBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public BaseRateSet.BaseRateSetBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public BaseRateSet.BaseRateSetBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public BaseRateSet.BaseRateSetBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public BaseRateSet.BaseRateSetBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public BaseRateSet.BaseRateSetBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public BaseRateSet.BaseRateSetBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public BaseRateSet.BaseRateSetBuilder setFixingDate(Date fixingDate) {
			this.fixingDate = fixingDate==null?null:fixingDate;
			return this;
		}
		@Override
		@RosettaAttribute("rate")
		public BaseRateSet.BaseRateSetBuilder setRate(BigDecimal rate) {
			this.rate = rate==null?null:rate;
			return this;
		}
		
		@Override
		public BaseRateSet build() {
			return new BaseRateSet.BaseRateSetImpl(this);
		}
		
		@Override
		public BaseRateSet.BaseRateSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BaseRateSet.BaseRateSetBuilder prune() {
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
		public BaseRateSet.BaseRateSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BaseRateSet.BaseRateSetBuilder o = (BaseRateSet.BaseRateSetBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "BaseRateSetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
