package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import cdm.base.staticdata.asset.common.Asset.AssetBuilderImpl;
import cdm.base.staticdata.asset.common.Asset.AssetImpl;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.meta.AssetMeta;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="Asset", builder=Asset.AssetBuilderImpl.class, version="6.0.0-dev.76")
public interface Asset extends RosettaModelObject {

	AssetMeta metaData = new AssetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An Asset that consists solely of a monetary holding in a currency.
	 */
	Cash getCash();
	/**
	 * An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
	 */
	FieldWithMetaCommodity getCommodity();
	/**
	 * An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
	 */
	DigitalAsset getDigitalAsset();
	/**
	 * An asset that is issued by one party to one or more others; Instrument is also a choice data type.
	 */
	Instrument getInstrument();

	/*********************** Build Methods  ***********************/
	Asset build();
	
	Asset.AssetBuilder toBuilder();
	
	static Asset.AssetBuilder builder() {
		return new Asset.AssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Asset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Asset> getType() {
		return Asset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Cash"), processor, Cash.class, getCash());
		processRosetta(path.newSubPath("Commodity"), processor, FieldWithMetaCommodity.class, getCommodity());
		processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.class, getDigitalAsset());
		processRosetta(path.newSubPath("Instrument"), processor, Instrument.class, getInstrument());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetBuilder extends Asset, RosettaModelObjectBuilder {
		Cash.CashBuilder getOrCreateCash();
		Cash.CashBuilder getCash();
		FieldWithMetaCommodity.FieldWithMetaCommodityBuilder getOrCreateCommodity();
		FieldWithMetaCommodity.FieldWithMetaCommodityBuilder getCommodity();
		DigitalAsset.DigitalAssetBuilder getOrCreateDigitalAsset();
		DigitalAsset.DigitalAssetBuilder getDigitalAsset();
		Instrument.InstrumentBuilder getOrCreateInstrument();
		Instrument.InstrumentBuilder getInstrument();
		Asset.AssetBuilder setCash(Cash _Cash);
		Asset.AssetBuilder setCommodity(FieldWithMetaCommodity Commodity0);
		Asset.AssetBuilder setCommodityValue(Commodity Commodity1);
		Asset.AssetBuilder setDigitalAsset(DigitalAsset _DigitalAsset);
		Asset.AssetBuilder setInstrument(Instrument _Instrument);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Cash"), processor, Cash.CashBuilder.class, getCash());
			processRosetta(path.newSubPath("Commodity"), processor, FieldWithMetaCommodity.FieldWithMetaCommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("DigitalAsset"), processor, DigitalAsset.DigitalAssetBuilder.class, getDigitalAsset());
			processRosetta(path.newSubPath("Instrument"), processor, Instrument.InstrumentBuilder.class, getInstrument());
		}
		

		Asset.AssetBuilder prune();
	}

	/*********************** Immutable Implementation of Asset  ***********************/
	class AssetImpl implements Asset {
		private final Cash cash;
		private final FieldWithMetaCommodity commodity;
		private final DigitalAsset digitalAsset;
		private final Instrument instrument;
		
		protected AssetImpl(Asset.AssetBuilder builder) {
			this.cash = ofNullable(builder.getCash()).map(f->f.build()).orElse(null);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.digitalAsset = ofNullable(builder.getDigitalAsset()).map(f->f.build()).orElse(null);
			this.instrument = ofNullable(builder.getInstrument()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Cash")
		public Cash getCash() {
			return cash;
		}
		
		@Override
		@RosettaAttribute("Commodity")
		public FieldWithMetaCommodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("DigitalAsset")
		public DigitalAsset getDigitalAsset() {
			return digitalAsset;
		}
		
		@Override
		@RosettaAttribute("Instrument")
		public Instrument getInstrument() {
			return instrument;
		}
		
		@Override
		public Asset build() {
			return this;
		}
		
		@Override
		public Asset.AssetBuilder toBuilder() {
			Asset.AssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Asset.AssetBuilder builder) {
			ofNullable(getCash()).ifPresent(builder::setCash);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getDigitalAsset()).ifPresent(builder::setDigitalAsset);
			ofNullable(getInstrument()).ifPresent(builder::setInstrument);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Asset _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(digitalAsset, _that.getDigitalAsset())) return false;
			if (!Objects.equals(instrument, _that.getInstrument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (digitalAsset != null ? digitalAsset.hashCode() : 0);
			_result = 31 * _result + (instrument != null ? instrument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Asset {" +
				"Cash=" + this.cash + ", " +
				"Commodity=" + this.commodity + ", " +
				"DigitalAsset=" + this.digitalAsset + ", " +
				"Instrument=" + this.instrument +
			'}';
		}
	}

	/*********************** Builder Implementation of Asset  ***********************/
	class AssetBuilderImpl implements Asset.AssetBuilder {
	
		protected Cash.CashBuilder cash;
		protected FieldWithMetaCommodity.FieldWithMetaCommodityBuilder commodity;
		protected DigitalAsset.DigitalAssetBuilder digitalAsset;
		protected Instrument.InstrumentBuilder instrument;
	
		public AssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("Cash")
		public Cash.CashBuilder getCash() {
			return cash;
		}
		
		@Override
		public Cash.CashBuilder getOrCreateCash() {
			Cash.CashBuilder result;
			if (cash!=null) {
				result = cash;
			}
			else {
				result = cash = Cash.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Commodity")
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder getOrCreateCommodity() {
			FieldWithMetaCommodity.FieldWithMetaCommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = FieldWithMetaCommodity.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DigitalAsset")
		public DigitalAsset.DigitalAssetBuilder getDigitalAsset() {
			return digitalAsset;
		}
		
		@Override
		public DigitalAsset.DigitalAssetBuilder getOrCreateDigitalAsset() {
			DigitalAsset.DigitalAssetBuilder result;
			if (digitalAsset!=null) {
				result = digitalAsset;
			}
			else {
				result = digitalAsset = DigitalAsset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Instrument")
		public Instrument.InstrumentBuilder getInstrument() {
			return instrument;
		}
		
		@Override
		public Instrument.InstrumentBuilder getOrCreateInstrument() {
			Instrument.InstrumentBuilder result;
			if (instrument!=null) {
				result = instrument;
			}
			else {
				result = instrument = Instrument.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Cash")
		public Asset.AssetBuilder setCash(Cash cash) {
			this.cash = cash==null?null:cash.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("Commodity")
		public Asset.AssetBuilder setCommodity(FieldWithMetaCommodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		public Asset.AssetBuilder setCommodityValue(Commodity commodity) {
			this.getOrCreateCommodity().setValue(commodity);
			return this;
		}
		@Override
		@RosettaAttribute("DigitalAsset")
		public Asset.AssetBuilder setDigitalAsset(DigitalAsset digitalAsset) {
			this.digitalAsset = digitalAsset==null?null:digitalAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("Instrument")
		public Asset.AssetBuilder setInstrument(Instrument instrument) {
			this.instrument = instrument==null?null:instrument.toBuilder();
			return this;
		}
		
		@Override
		public Asset build() {
			return new Asset.AssetImpl(this);
		}
		
		@Override
		public Asset.AssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Asset.AssetBuilder prune() {
			if (cash!=null && !cash.prune().hasData()) cash = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (digitalAsset!=null && !digitalAsset.prune().hasData()) digitalAsset = null;
			if (instrument!=null && !instrument.prune().hasData()) instrument = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCash()!=null && getCash().hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getDigitalAsset()!=null && getDigitalAsset().hasData()) return true;
			if (getInstrument()!=null && getInstrument().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Asset.AssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Asset.AssetBuilder o = (Asset.AssetBuilder) other;
			
			merger.mergeRosetta(getCash(), o.getCash(), this::setCash);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getDigitalAsset(), o.getDigitalAsset(), this::setDigitalAsset);
			merger.mergeRosetta(getInstrument(), o.getInstrument(), this::setInstrument);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Asset _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(digitalAsset, _that.getDigitalAsset())) return false;
			if (!Objects.equals(instrument, _that.getInstrument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (digitalAsset != null ? digitalAsset.hashCode() : 0);
			_result = 31 * _result + (instrument != null ? instrument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetBuilder {" +
				"Cash=" + this.cash + ", " +
				"Commodity=" + this.commodity + ", " +
				"DigitalAsset=" + this.digitalAsset + ", " +
				"Instrument=" + this.instrument +
			'}';
		}
	}
}
