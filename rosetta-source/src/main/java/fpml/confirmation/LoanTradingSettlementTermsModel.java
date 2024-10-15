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
import fpml.confirmation.LoanTradingAssocEnum;
import fpml.confirmation.LoanTradingFormOfPurchaseEnum;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder;
import fpml.confirmation.LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilderImpl;
import fpml.confirmation.LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelImpl;
import fpml.confirmation.meta.LoanTradingSettlementTermsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model which contains settlement terms of a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingSettlementTermsModel", builder=LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilderImpl.class, version="${project.version}")
public interface LoanTradingSettlementTermsModel extends RosettaModelObject {

	LoanTradingSettlementTermsModelMeta metaData = new LoanTradingSettlementTermsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the trading association under which the loan trade documentation is governed.
	 */
	LoanTradingAssocEnum getTradingAssociation();
	/**
	 * Defines whether the trade is being settled by assignment or participation (i.e. sub-participation).
	 */
	LoanTradingFormOfPurchaseEnum getFormOfPurchase();

	/*********************** Build Methods  ***********************/
	LoanTradingSettlementTermsModel build();
	
	LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder toBuilder();
	
	static LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder builder() {
		return new LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingSettlementTermsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingSettlementTermsModel> getType() {
		return LoanTradingSettlementTermsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradingAssociation"), LoanTradingAssocEnum.class, getTradingAssociation(), this);
		processor.processBasic(path.newSubPath("formOfPurchase"), LoanTradingFormOfPurchaseEnum.class, getFormOfPurchase(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingSettlementTermsModelBuilder extends LoanTradingSettlementTermsModel, RosettaModelObjectBuilder {
		LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder setTradingAssociation(LoanTradingAssocEnum tradingAssociation);
		LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder setFormOfPurchase(LoanTradingFormOfPurchaseEnum formOfPurchase);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tradingAssociation"), LoanTradingAssocEnum.class, getTradingAssociation(), this);
			processor.processBasic(path.newSubPath("formOfPurchase"), LoanTradingFormOfPurchaseEnum.class, getFormOfPurchase(), this);
		}
		

		LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingSettlementTermsModel  ***********************/
	class LoanTradingSettlementTermsModelImpl implements LoanTradingSettlementTermsModel {
		private final LoanTradingAssocEnum tradingAssociation;
		private final LoanTradingFormOfPurchaseEnum formOfPurchase;
		
		protected LoanTradingSettlementTermsModelImpl(LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder builder) {
			this.tradingAssociation = builder.getTradingAssociation();
			this.formOfPurchase = builder.getFormOfPurchase();
		}
		
		@Override
		@RosettaAttribute("tradingAssociation")
		public LoanTradingAssocEnum getTradingAssociation() {
			return tradingAssociation;
		}
		
		@Override
		@RosettaAttribute("formOfPurchase")
		public LoanTradingFormOfPurchaseEnum getFormOfPurchase() {
			return formOfPurchase;
		}
		
		@Override
		public LoanTradingSettlementTermsModel build() {
			return this;
		}
		
		@Override
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder toBuilder() {
			LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder builder) {
			ofNullable(getTradingAssociation()).ifPresent(builder::setTradingAssociation);
			ofNullable(getFormOfPurchase()).ifPresent(builder::setFormOfPurchase);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingAssociation, _that.getTradingAssociation())) return false;
			if (!Objects.equals(formOfPurchase, _that.getFormOfPurchase())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingAssociation != null ? tradingAssociation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (formOfPurchase != null ? formOfPurchase.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementTermsModel {" +
				"tradingAssociation=" + this.tradingAssociation + ", " +
				"formOfPurchase=" + this.formOfPurchase +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingSettlementTermsModel  ***********************/
	class LoanTradingSettlementTermsModelBuilderImpl implements LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder {
	
		protected LoanTradingAssocEnum tradingAssociation;
		protected LoanTradingFormOfPurchaseEnum formOfPurchase;
	
		public LoanTradingSettlementTermsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingAssociation")
		public LoanTradingAssocEnum getTradingAssociation() {
			return tradingAssociation;
		}
		
		@Override
		@RosettaAttribute("formOfPurchase")
		public LoanTradingFormOfPurchaseEnum getFormOfPurchase() {
			return formOfPurchase;
		}
		
		@Override
		@RosettaAttribute("tradingAssociation")
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder setTradingAssociation(LoanTradingAssocEnum tradingAssociation) {
			this.tradingAssociation = tradingAssociation==null?null:tradingAssociation;
			return this;
		}
		@Override
		@RosettaAttribute("formOfPurchase")
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder setFormOfPurchase(LoanTradingFormOfPurchaseEnum formOfPurchase) {
			this.formOfPurchase = formOfPurchase==null?null:formOfPurchase;
			return this;
		}
		
		@Override
		public LoanTradingSettlementTermsModel build() {
			return new LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelImpl(this);
		}
		
		@Override
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradingAssociation()!=null) return true;
			if (getFormOfPurchase()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder o = (LoanTradingSettlementTermsModel.LoanTradingSettlementTermsModelBuilder) other;
			
			
			merger.mergeBasic(getTradingAssociation(), o.getTradingAssociation(), this::setTradingAssociation);
			merger.mergeBasic(getFormOfPurchase(), o.getFormOfPurchase(), this::setFormOfPurchase);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingSettlementTermsModel _that = getType().cast(o);
		
			if (!Objects.equals(tradingAssociation, _that.getTradingAssociation())) return false;
			if (!Objects.equals(formOfPurchase, _that.getFormOfPurchase())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradingAssociation != null ? tradingAssociation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (formOfPurchase != null ? formOfPurchase.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingSettlementTermsModelBuilder {" +
				"tradingAssociation=" + this.tradingAssociation + ", " +
				"formOfPurchase=" + this.formOfPurchase +
			'}';
		}
	}
}
