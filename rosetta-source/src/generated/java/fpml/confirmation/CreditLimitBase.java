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
import fpml.confirmation.CreditLimitBase;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseBuilder;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseBuilderImpl;
import fpml.confirmation.CreditLimitBase.CreditLimitBaseImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CreditLimitBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a basic credit limit.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditLimitBase", builder=CreditLimitBase.CreditLimitBaseBuilderImpl.class, version="${project.version}")
public interface CreditLimitBase extends RosettaModelObject {

	CreditLimitBaseMeta metaData = new CreditLimitBaseMeta();

	/*********************** Getter Methods  ***********************/
	LimitId getLimitId();
	ProductModel getProductModel();
	Currency getCurrency();
	/**
	 * The maximum allowed tenor for a trade under this limit. When this structure is used as part of a suspendCredit message, this tenor imposes a temporary tenor limit on allowed trade types.
	 */
	Period getTenor();

	/*********************** Build Methods  ***********************/
	CreditLimitBase build();
	
	CreditLimitBase.CreditLimitBaseBuilder toBuilder();
	
	static CreditLimitBase.CreditLimitBaseBuilder builder() {
		return new CreditLimitBase.CreditLimitBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditLimitBase> getType() {
		return CreditLimitBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("limitId"), processor, LimitId.class, getLimitId());
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitBaseBuilder extends CreditLimitBase, RosettaModelObjectBuilder {
		LimitId.LimitIdBuilder getOrCreateLimitId();
		LimitId.LimitIdBuilder getLimitId();
		ProductModel.ProductModelBuilder getOrCreateProductModel();
		ProductModel.ProductModelBuilder getProductModel();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		Period.PeriodBuilder getOrCreateTenor();
		Period.PeriodBuilder getTenor();
		CreditLimitBase.CreditLimitBaseBuilder setLimitId(LimitId limitId);
		CreditLimitBase.CreditLimitBaseBuilder setProductModel(ProductModel productModel);
		CreditLimitBase.CreditLimitBaseBuilder setCurrency(Currency currency);
		CreditLimitBase.CreditLimitBaseBuilder setTenor(Period tenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("limitId"), processor, LimitId.LimitIdBuilder.class, getLimitId());
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
		}
		

		CreditLimitBase.CreditLimitBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitBase  ***********************/
	class CreditLimitBaseImpl implements CreditLimitBase {
		private final LimitId limitId;
		private final ProductModel productModel;
		private final Currency currency;
		private final Period tenor;
		
		protected CreditLimitBaseImpl(CreditLimitBase.CreditLimitBaseBuilder builder) {
			this.limitId = ofNullable(builder.getLimitId()).map(f->f.build()).orElse(null);
			this.productModel = ofNullable(builder.getProductModel()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("limitId")
		public LimitId getLimitId() {
			return limitId;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public ProductModel getProductModel() {
			return productModel;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("tenor")
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		public CreditLimitBase build() {
			return this;
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder toBuilder() {
			CreditLimitBase.CreditLimitBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitBase.CreditLimitBaseBuilder builder) {
			ofNullable(getLimitId()).ifPresent(builder::setLimitId);
			ofNullable(getProductModel()).ifPresent(builder::setProductModel);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getTenor()).ifPresent(builder::setTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitBase _that = getType().cast(o);
		
			if (!Objects.equals(limitId, _that.getLimitId())) return false;
			if (!Objects.equals(productModel, _that.getProductModel())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitId != null ? limitId.hashCode() : 0);
			_result = 31 * _result + (productModel != null ? productModel.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBase {" +
				"limitId=" + this.limitId + ", " +
				"productModel=" + this.productModel + ", " +
				"currency=" + this.currency + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitBase  ***********************/
	class CreditLimitBaseBuilderImpl implements CreditLimitBase.CreditLimitBaseBuilder {
	
		protected LimitId.LimitIdBuilder limitId;
		protected ProductModel.ProductModelBuilder productModel;
		protected Currency.CurrencyBuilder currency;
		protected Period.PeriodBuilder tenor;
	
		public CreditLimitBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("limitId")
		public LimitId.LimitIdBuilder getLimitId() {
			return limitId;
		}
		
		@Override
		public LimitId.LimitIdBuilder getOrCreateLimitId() {
			LimitId.LimitIdBuilder result;
			if (limitId!=null) {
				result = limitId;
			}
			else {
				result = limitId = LimitId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public ProductModel.ProductModelBuilder getProductModel() {
			return productModel;
		}
		
		@Override
		public ProductModel.ProductModelBuilder getOrCreateProductModel() {
			ProductModel.ProductModelBuilder result;
			if (productModel!=null) {
				result = productModel;
			}
			else {
				result = productModel = ProductModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenor")
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("limitId")
		public CreditLimitBase.CreditLimitBaseBuilder setLimitId(LimitId limitId) {
			this.limitId = limitId==null?null:limitId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("productModel")
		public CreditLimitBase.CreditLimitBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public CreditLimitBase.CreditLimitBaseBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tenor")
		public CreditLimitBase.CreditLimitBaseBuilder setTenor(Period tenor) {
			this.tenor = tenor==null?null:tenor.toBuilder();
			return this;
		}
		
		@Override
		public CreditLimitBase build() {
			return new CreditLimitBase.CreditLimitBaseImpl(this);
		}
		
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder prune() {
			if (limitId!=null && !limitId.prune().hasData()) limitId = null;
			if (productModel!=null && !productModel.prune().hasData()) productModel = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitId()!=null && getLimitId().hasData()) return true;
			if (getProductModel()!=null && getProductModel().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getTenor()!=null && getTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitBase.CreditLimitBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitBase.CreditLimitBaseBuilder o = (CreditLimitBase.CreditLimitBaseBuilder) other;
			
			merger.mergeRosetta(getLimitId(), o.getLimitId(), this::setLimitId);
			merger.mergeRosetta(getProductModel(), o.getProductModel(), this::setProductModel);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitBase _that = getType().cast(o);
		
			if (!Objects.equals(limitId, _that.getLimitId())) return false;
			if (!Objects.equals(productModel, _that.getProductModel())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitId != null ? limitId.hashCode() : 0);
			_result = 31 * _result + (productModel != null ? productModel.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitBaseBuilder {" +
				"limitId=" + this.limitId + ", " +
				"productModel=" + this.productModel + ", " +
				"currency=" + this.currency + ", " +
				"tenor=" + this.tenor +
			'}';
		}
	}
}
