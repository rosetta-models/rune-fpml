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
import fpml.confirmation.CommodityBase;
import fpml.confirmation.CommodityDetails;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder;
import fpml.confirmation.CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilderImpl;
import fpml.confirmation.CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.CommodityReferencePriceFrameworkModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group used to specify the commodity underlyer in the event that no ISDA Commofity Reference Price exists.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityReferencePriceFrameworkModel", builder=CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilderImpl.class, version="${project.version}")
public interface CommodityReferencePriceFrameworkModel extends RosettaModelObject {

	CommodityReferencePriceFrameworkModelMeta metaData = new CommodityReferencePriceFrameworkModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A coding scheme value to identify the base type of the commodity being traded. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, &#39;Oil&#39;.
	 */
	CommodityBase getCommodityBase();
	/**
	 * A coding scheme value to identify the commodity being traded more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions. For example, &#39;Brent&#39;.
	 */
	CommodityDetails getCommodityDetails();
	/**
	 * A coding scheme value to identify the unit of measure (e.g. Therms) in which the undelryer is denominated. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions.
	 */
	QuantityUnit getUnit();
	/**
	 * The currency in which the Commodity Reference Price is published (e.g. GBP).
	 */
	Currency getCurrency();
	/**
	 * For those commodities being traded with reference to the price of a listed instrument, the exchange where that instrument is listed should be specified in the &#39;exchange&#39; element.
	 */
	ExchangeId getExchangeId();
	/**
	 * For those commodities being traded with reference to a price distributed by a publication, that publication should be specified in the &#39;publication&#39; element.
	 */
	CommodityInformationSource getPublication();

	/*********************** Build Methods  ***********************/
	CommodityReferencePriceFrameworkModel build();
	
	CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder toBuilder();
	
	static CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder builder() {
		return new CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityReferencePriceFrameworkModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityReferencePriceFrameworkModel> getType() {
		return CommodityReferencePriceFrameworkModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityBase"), processor, CommodityBase.class, getCommodityBase());
		processRosetta(path.newSubPath("commodityDetails"), processor, CommodityDetails.class, getCommodityDetails());
		processRosetta(path.newSubPath("unit"), processor, QuantityUnit.class, getUnit());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("publication"), processor, CommodityInformationSource.class, getPublication());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityReferencePriceFrameworkModelBuilder extends CommodityReferencePriceFrameworkModel, RosettaModelObjectBuilder {
		CommodityBase.CommodityBaseBuilder getOrCreateCommodityBase();
		CommodityBase.CommodityBaseBuilder getCommodityBase();
		CommodityDetails.CommodityDetailsBuilder getOrCreateCommodityDetails();
		CommodityDetails.CommodityDetailsBuilder getCommodityDetails();
		QuantityUnit.QuantityUnitBuilder getOrCreateUnit();
		QuantityUnit.QuantityUnitBuilder getUnit();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		ExchangeId.ExchangeIdBuilder getExchangeId();
		CommodityInformationSource.CommodityInformationSourceBuilder getOrCreatePublication();
		CommodityInformationSource.CommodityInformationSourceBuilder getPublication();
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCommodityBase(CommodityBase commodityBase);
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCommodityDetails(CommodityDetails commodityDetails);
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setUnit(QuantityUnit unit);
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCurrency(Currency currency);
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setExchangeId(ExchangeId exchangeId);
		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setPublication(CommodityInformationSource publication);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityBase"), processor, CommodityBase.CommodityBaseBuilder.class, getCommodityBase());
			processRosetta(path.newSubPath("commodityDetails"), processor, CommodityDetails.CommodityDetailsBuilder.class, getCommodityDetails());
			processRosetta(path.newSubPath("unit"), processor, QuantityUnit.QuantityUnitBuilder.class, getUnit());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("publication"), processor, CommodityInformationSource.CommodityInformationSourceBuilder.class, getPublication());
		}
		

		CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityReferencePriceFrameworkModel  ***********************/
	class CommodityReferencePriceFrameworkModelImpl implements CommodityReferencePriceFrameworkModel {
		private final CommodityBase commodityBase;
		private final CommodityDetails commodityDetails;
		private final QuantityUnit unit;
		private final Currency currency;
		private final ExchangeId exchangeId;
		private final CommodityInformationSource publication;
		
		protected CommodityReferencePriceFrameworkModelImpl(CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder builder) {
			this.commodityBase = ofNullable(builder.getCommodityBase()).map(f->f.build()).orElse(null);
			this.commodityDetails = ofNullable(builder.getCommodityDetails()).map(f->f.build()).orElse(null);
			this.unit = ofNullable(builder.getUnit()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.publication = ofNullable(builder.getPublication()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityBase")
		public CommodityBase getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		public CommodityDetails getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		@RosettaAttribute("publication")
		public CommodityInformationSource getPublication() {
			return publication;
		}
		
		@Override
		public CommodityReferencePriceFrameworkModel build() {
			return this;
		}
		
		@Override
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder toBuilder() {
			CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder builder) {
			ofNullable(getCommodityBase()).ifPresent(builder::setCommodityBase);
			ofNullable(getCommodityDetails()).ifPresent(builder::setCommodityDetails);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getPublication()).ifPresent(builder::setPublication);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReferencePriceFrameworkModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(publication, _that.getPublication())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (publication != null ? publication.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReferencePriceFrameworkModel {" +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityDetails=" + this.commodityDetails + ", " +
				"unit=" + this.unit + ", " +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"publication=" + this.publication +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityReferencePriceFrameworkModel  ***********************/
	class CommodityReferencePriceFrameworkModelBuilderImpl implements CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder {
	
		protected CommodityBase.CommodityBaseBuilder commodityBase;
		protected CommodityDetails.CommodityDetailsBuilder commodityDetails;
		protected QuantityUnit.QuantityUnitBuilder unit;
		protected Currency.CurrencyBuilder currency;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
		protected CommodityInformationSource.CommodityInformationSourceBuilder publication;
	
		public CommodityReferencePriceFrameworkModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityBase")
		public CommodityBase.CommodityBaseBuilder getCommodityBase() {
			return commodityBase;
		}
		
		@Override
		public CommodityBase.CommodityBaseBuilder getOrCreateCommodityBase() {
			CommodityBase.CommodityBaseBuilder result;
			if (commodityBase!=null) {
				result = commodityBase;
			}
			else {
				result = commodityBase = CommodityBase.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityDetails")
		public CommodityDetails.CommodityDetailsBuilder getCommodityDetails() {
			return commodityDetails;
		}
		
		@Override
		public CommodityDetails.CommodityDetailsBuilder getOrCreateCommodityDetails() {
			CommodityDetails.CommodityDetailsBuilder result;
			if (commodityDetails!=null) {
				result = commodityDetails;
			}
			else {
				result = commodityDetails = CommodityDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit.QuantityUnitBuilder getUnit() {
			return unit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (unit!=null) {
				result = unit;
			}
			else {
				result = unit = QuantityUnit.builder();
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
		@RosettaAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publication")
		public CommodityInformationSource.CommodityInformationSourceBuilder getPublication() {
			return publication;
		}
		
		@Override
		public CommodityInformationSource.CommodityInformationSourceBuilder getOrCreatePublication() {
			CommodityInformationSource.CommodityInformationSourceBuilder result;
			if (publication!=null) {
				result = publication;
			}
			else {
				result = publication = CommodityInformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityBase")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCommodityBase(CommodityBase commodityBase) {
			this.commodityBase = commodityBase==null?null:commodityBase.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityDetails")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCommodityDetails(CommodityDetails commodityDetails) {
			this.commodityDetails = commodityDetails==null?null:commodityDetails.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unit")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setUnit(QuantityUnit unit) {
			this.unit = unit==null?null:unit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("publication")
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder setPublication(CommodityInformationSource publication) {
			this.publication = publication==null?null:publication.toBuilder();
			return this;
		}
		
		@Override
		public CommodityReferencePriceFrameworkModel build() {
			return new CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelImpl(this);
		}
		
		@Override
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder prune() {
			if (commodityBase!=null && !commodityBase.prune().hasData()) commodityBase = null;
			if (commodityDetails!=null && !commodityDetails.prune().hasData()) commodityDetails = null;
			if (unit!=null && !unit.prune().hasData()) unit = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			if (publication!=null && !publication.prune().hasData()) publication = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityBase()!=null && getCommodityBase().hasData()) return true;
			if (getCommodityDetails()!=null && getCommodityDetails().hasData()) return true;
			if (getUnit()!=null && getUnit().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			if (getPublication()!=null && getPublication().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder o = (CommodityReferencePriceFrameworkModel.CommodityReferencePriceFrameworkModelBuilder) other;
			
			merger.mergeRosetta(getCommodityBase(), o.getCommodityBase(), this::setCommodityBase);
			merger.mergeRosetta(getCommodityDetails(), o.getCommodityDetails(), this::setCommodityDetails);
			merger.mergeRosetta(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getPublication(), o.getPublication(), this::setPublication);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityReferencePriceFrameworkModel _that = getType().cast(o);
		
			if (!Objects.equals(commodityBase, _that.getCommodityBase())) return false;
			if (!Objects.equals(commodityDetails, _that.getCommodityDetails())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(publication, _that.getPublication())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityBase != null ? commodityBase.hashCode() : 0);
			_result = 31 * _result + (commodityDetails != null ? commodityDetails.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (publication != null ? publication.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityReferencePriceFrameworkModelBuilder {" +
				"commodityBase=" + this.commodityBase + ", " +
				"commodityDetails=" + this.commodityDetails + ", " +
				"unit=" + this.unit + ", " +
				"currency=" + this.currency + ", " +
				"exchangeId=" + this.exchangeId + ", " +
				"publication=" + this.publication +
			'}';
		}
	}
}
