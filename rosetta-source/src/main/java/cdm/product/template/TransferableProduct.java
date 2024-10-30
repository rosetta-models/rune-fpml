package cdm.product.template;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.asset.common.Asset.AssetBuilderImpl;
import cdm.base.staticdata.asset.common.Asset.AssetImpl;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityBuilder;
import cdm.product.template.EconomicTerms;
import cdm.product.template.TransferableProduct;
import cdm.product.template.TransferableProduct.TransferableProductBuilder;
import cdm.product.template.TransferableProduct.TransferableProductBuilderImpl;
import cdm.product.template.TransferableProduct.TransferableProductImpl;
import cdm.product.template.meta.TransferableProductMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A TransferableProduct is a type of financial product which can be held or transferred, represented as an Asset with the addition of specific EconomicTerms.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="TransferableProduct", builder=TransferableProduct.TransferableProductBuilderImpl.class, version="6.0.0-dev.76")
public interface TransferableProduct extends Asset {

	TransferableProductMeta metaData = new TransferableProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The price forming features, including payouts and provisions.
	 */
	EconomicTerms getEconomicTerms();

	/*********************** Build Methods  ***********************/
	TransferableProduct build();
	
	TransferableProduct.TransferableProductBuilder toBuilder();
	
	static TransferableProduct.TransferableProductBuilder builder() {
		return new TransferableProduct.TransferableProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransferableProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransferableProduct> getType() {
		return TransferableProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Cash"), processor, Cash.class, getCash());
		processRosetta(path.newSubPath("Commodity"), processor, FieldWithMetaCommodity.class, getCommodity());
		processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.class, getDigitalAsset());
		processRosetta(path.newSubPath("Instrument"), processor, Instrument.class, getInstrument());
		processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.class, getEconomicTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferableProductBuilder extends TransferableProduct, Asset.AssetBuilder {
		EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms();
		EconomicTerms.EconomicTermsBuilder getEconomicTerms();
		TransferableProduct.TransferableProductBuilder setCash(Cash _Cash);
		TransferableProduct.TransferableProductBuilder setCommodity(FieldWithMetaCommodity Commodity0);
		TransferableProduct.TransferableProductBuilder setCommodityValue(Commodity Commodity1);
		TransferableProduct.TransferableProductBuilder setDigitalAsset(DigitalAsset _DigitalAsset);
		TransferableProduct.TransferableProductBuilder setInstrument(Instrument _Instrument);
		TransferableProduct.TransferableProductBuilder setEconomicTerms(EconomicTerms economicTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Cash"), processor, Cash.CashBuilder.class, getCash());
			processRosetta(path.newSubPath("Commodity"), processor, FieldWithMetaCommodity.FieldWithMetaCommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.DigitalAssetBuilder.class, getDigitalAsset());
			processRosetta(path.newSubPath("Instrument"), processor, Instrument.InstrumentBuilder.class, getInstrument());
			processRosetta(path.newSubPath("economicTerms"), processor, EconomicTerms.EconomicTermsBuilder.class, getEconomicTerms());
		}
		

		TransferableProduct.TransferableProductBuilder prune();
	}

	/*********************** Immutable Implementation of TransferableProduct  ***********************/
	class TransferableProductImpl extends Asset.AssetImpl implements TransferableProduct {
		private final EconomicTerms economicTerms;
		
		protected TransferableProductImpl(TransferableProduct.TransferableProductBuilder builder) {
			super(builder);
			this.economicTerms = ofNullable(builder.getEconomicTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("economicTerms")
		public EconomicTerms getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		public TransferableProduct build() {
			return this;
		}
		
		@Override
		public TransferableProduct.TransferableProductBuilder toBuilder() {
			TransferableProduct.TransferableProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferableProduct.TransferableProductBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEconomicTerms()).ifPresent(builder::setEconomicTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransferableProduct _that = getType().cast(o);
		
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferableProduct {" +
				"economicTerms=" + this.economicTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TransferableProduct  ***********************/
	class TransferableProductBuilderImpl extends Asset.AssetBuilderImpl  implements TransferableProduct.TransferableProductBuilder {
	
		protected EconomicTerms.EconomicTermsBuilder economicTerms;
	
		public TransferableProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("economicTerms")
		public EconomicTerms.EconomicTermsBuilder getEconomicTerms() {
			return economicTerms;
		}
		
		@Override
		public EconomicTerms.EconomicTermsBuilder getOrCreateEconomicTerms() {
			EconomicTerms.EconomicTermsBuilder result;
			if (economicTerms!=null) {
				result = economicTerms;
			}
			else {
				result = economicTerms = EconomicTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Cash")
		public TransferableProduct.TransferableProductBuilder setCash(Cash cash) {
			this.cash = cash==null?null:cash.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("Commodity")
		public TransferableProduct.TransferableProductBuilder setCommodity(FieldWithMetaCommodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		public TransferableProduct.TransferableProductBuilder setCommodityValue(Commodity commodity) {
			this.getOrCreateCommodity().setValue(commodity);
			return this;
		}
		@Override
		@RosettaAttribute("DigitalAsset")
		public TransferableProduct.TransferableProductBuilder setDigitalAsset(DigitalAsset digitalAsset) {
			this.digitalAsset = digitalAsset==null?null:digitalAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("Instrument")
		public TransferableProduct.TransferableProductBuilder setInstrument(Instrument instrument) {
			this.instrument = instrument==null?null:instrument.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("economicTerms")
		public TransferableProduct.TransferableProductBuilder setEconomicTerms(EconomicTerms economicTerms) {
			this.economicTerms = economicTerms==null?null:economicTerms.toBuilder();
			return this;
		}
		
		@Override
		public TransferableProduct build() {
			return new TransferableProduct.TransferableProductImpl(this);
		}
		
		@Override
		public TransferableProduct.TransferableProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferableProduct.TransferableProductBuilder prune() {
			super.prune();
			if (economicTerms!=null && !economicTerms.prune().hasData()) economicTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEconomicTerms()!=null && getEconomicTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferableProduct.TransferableProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TransferableProduct.TransferableProductBuilder o = (TransferableProduct.TransferableProductBuilder) other;
			
			merger.mergeRosetta(getEconomicTerms(), o.getEconomicTerms(), this::setEconomicTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TransferableProduct _that = getType().cast(o);
		
			if (!Objects.equals(economicTerms, _that.getEconomicTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (economicTerms != null ? economicTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferableProductBuilder {" +
				"economicTerms=" + this.economicTerms +
			'}' + " " + super.toString();
		}
	}
}
