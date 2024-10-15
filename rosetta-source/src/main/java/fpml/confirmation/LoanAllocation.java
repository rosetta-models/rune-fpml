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
import fpml.confirmation.AbstractLoanAllocationSummary;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryImpl;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.LoanAllocation;
import fpml.confirmation.LoanAllocation.LoanAllocationBuilder;
import fpml.confirmation.LoanAllocation.LoanAllocationBuilderImpl;
import fpml.confirmation.LoanAllocation.LoanAllocationImpl;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.Money;
import fpml.confirmation.meta.LoanAllocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An event structure defining information related to a loan trade allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocation", builder=LoanAllocation.LoanAllocationBuilderImpl.class, version="${project.version}")
public interface LoanAllocation extends AbstractLoanAllocationSummary {

	LoanAllocationMeta metaData = new LoanAllocationMeta();

	/*********************** Getter Methods  ***********************/
	LoanAllocationPartiesModel getLoanAllocationPartiesModel();
	BuyerSellerModel getBuyerSellerModel();

	/*********************** Build Methods  ***********************/
	LoanAllocation build();
	
	LoanAllocation.LoanAllocationBuilder toBuilder();
	
	static LoanAllocation.LoanAllocationBuilder builder() {
		return new LoanAllocation.LoanAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocation> getType() {
		return LoanAllocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.class, getAllocationIdentifier());
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("loanAllocationPartiesModel"), processor, LoanAllocationPartiesModel.class, getLoanAllocationPartiesModel());
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationBuilder extends LoanAllocation, AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilder {
		LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder getOrCreateLoanAllocationPartiesModel();
		LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder getLoanAllocationPartiesModel();
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		LoanAllocation.LoanAllocationBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier);
		LoanAllocation.LoanAllocationBuilder setAmount(Money amount);
		LoanAllocation.LoanAllocationBuilder setComment(String comment);
		LoanAllocation.LoanAllocationBuilder setLoanAllocationPartiesModel(LoanAllocationPartiesModel loanAllocationPartiesModel);
		LoanAllocation.LoanAllocationBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationIdentifier"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationIdentifier());
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanAllocationPartiesModel"), processor, LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder.class, getLoanAllocationPartiesModel());
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
		}
		

		LoanAllocation.LoanAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocation  ***********************/
	class LoanAllocationImpl extends AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryImpl implements LoanAllocation {
		private final LoanAllocationPartiesModel loanAllocationPartiesModel;
		private final BuyerSellerModel buyerSellerModel;
		
		protected LoanAllocationImpl(LoanAllocation.LoanAllocationBuilder builder) {
			super(builder);
			this.loanAllocationPartiesModel = ofNullable(builder.getLoanAllocationPartiesModel()).map(f->f.build()).orElse(null);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanAllocationPartiesModel")
		public LoanAllocationPartiesModel getLoanAllocationPartiesModel() {
			return loanAllocationPartiesModel;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public LoanAllocation build() {
			return this;
		}
		
		@Override
		public LoanAllocation.LoanAllocationBuilder toBuilder() {
			LoanAllocation.LoanAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocation.LoanAllocationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanAllocationPartiesModel()).ifPresent(builder::setLoanAllocationPartiesModel);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocation _that = getType().cast(o);
		
			if (!Objects.equals(loanAllocationPartiesModel, _that.getLoanAllocationPartiesModel())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationPartiesModel != null ? loanAllocationPartiesModel.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocation {" +
				"loanAllocationPartiesModel=" + this.loanAllocationPartiesModel + ", " +
				"buyerSellerModel=" + this.buyerSellerModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocation  ***********************/
	class LoanAllocationBuilderImpl extends AbstractLoanAllocationSummary.AbstractLoanAllocationSummaryBuilderImpl  implements LoanAllocation.LoanAllocationBuilder {
	
		protected LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder loanAllocationPartiesModel;
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
	
		public LoanAllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanAllocationPartiesModel")
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder getLoanAllocationPartiesModel() {
			return loanAllocationPartiesModel;
		}
		
		@Override
		public LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder getOrCreateLoanAllocationPartiesModel() {
			LoanAllocationPartiesModel.LoanAllocationPartiesModelBuilder result;
			if (loanAllocationPartiesModel!=null) {
				result = loanAllocationPartiesModel;
			}
			else {
				result = loanAllocationPartiesModel = LoanAllocationPartiesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationIdentifier")
		public LoanAllocation.LoanAllocationBuilder setAllocationIdentifier(LoanAllocationIdentifier allocationIdentifier) {
			this.allocationIdentifier = allocationIdentifier==null?null:allocationIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LoanAllocation.LoanAllocationBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocation.LoanAllocationBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanAllocationPartiesModel")
		public LoanAllocation.LoanAllocationBuilder setLoanAllocationPartiesModel(LoanAllocationPartiesModel loanAllocationPartiesModel) {
			this.loanAllocationPartiesModel = loanAllocationPartiesModel==null?null:loanAllocationPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public LoanAllocation.LoanAllocationBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocation build() {
			return new LoanAllocation.LoanAllocationImpl(this);
		}
		
		@Override
		public LoanAllocation.LoanAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocation.LoanAllocationBuilder prune() {
			super.prune();
			if (loanAllocationPartiesModel!=null && !loanAllocationPartiesModel.prune().hasData()) loanAllocationPartiesModel = null;
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanAllocationPartiesModel()!=null && getLoanAllocationPartiesModel().hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocation.LoanAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocation.LoanAllocationBuilder o = (LoanAllocation.LoanAllocationBuilder) other;
			
			merger.mergeRosetta(getLoanAllocationPartiesModel(), o.getLoanAllocationPartiesModel(), this::setLoanAllocationPartiesModel);
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocation _that = getType().cast(o);
		
			if (!Objects.equals(loanAllocationPartiesModel, _that.getLoanAllocationPartiesModel())) return false;
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationPartiesModel != null ? loanAllocationPartiesModel.hashCode() : 0);
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationBuilder {" +
				"loanAllocationPartiesModel=" + this.loanAllocationPartiesModel + ", " +
				"buyerSellerModel=" + this.buyerSellerModel +
			'}' + " " + super.toString();
		}
	}
}
