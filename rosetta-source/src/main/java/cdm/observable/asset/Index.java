package cdm.observable.asset;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.Index.IndexBuilder;
import cdm.observable.asset.Index.IndexBuilderImpl;
import cdm.observable.asset.Index.IndexImpl;
import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.meta.IndexMeta;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder;
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
 * An Index is an Observable which is computed based on the prices, rates or valuations of a number of assets that are tracked in a standardized way.  Examples include equity market indices as well as indices on interest rates, inflation and credit instruments.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="Index", builder=Index.IndexBuilderImpl.class, version="6.0.0-dev.76")
public interface Index extends RosettaModelObject {

	IndexMeta metaData = new IndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
	 */
	CreditIndex getCreditIndex();
	/**
	 * An index based on equity securities, e.g. the S&amp;P 500.
	 */
	EquityIndex getEquityIndex();
	/**
	 * An index based in interest rates or inflation rates in a certain market.
	 */
	FieldWithMetaFloatingRateIndex getFloatingRateIndex();
	/**
	 * A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
	 */
	ForeignExchangeRateIndex getForeignExchangeRateIndex();
	/**
	 * An index created by a market participant which doesn&#39;t align with the other index types.
	 */
	OtherIndex getOtherIndex();

	/*********************** Build Methods  ***********************/
	Index build();
	
	Index.IndexBuilder toBuilder();
	
	static Index.IndexBuilder builder() {
		return new Index.IndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Index> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Index> getType() {
		return Index.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("CreditIndex"), processor, CreditIndex.class, getCreditIndex());
		processRosetta(path.newSubPath("EquityIndex"), processor, EquityIndex.class, getEquityIndex());
		processRosetta(path.newSubPath("FloatingRateIndex"), processor, FieldWithMetaFloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("ForeignExchangeRateIndex"), processor, ForeignExchangeRateIndex.class, getForeignExchangeRateIndex());
		processRosetta(path.newSubPath("OtherIndex"), processor, OtherIndex.class, getOtherIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexBuilder extends Index, RosettaModelObjectBuilder {
		CreditIndex.CreditIndexBuilder getOrCreateCreditIndex();
		CreditIndex.CreditIndexBuilder getCreditIndex();
		EquityIndex.EquityIndexBuilder getOrCreateEquityIndex();
		EquityIndex.EquityIndexBuilder getEquityIndex();
		FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder getFloatingRateIndex();
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder getOrCreateForeignExchangeRateIndex();
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder getForeignExchangeRateIndex();
		OtherIndex.OtherIndexBuilder getOrCreateOtherIndex();
		OtherIndex.OtherIndexBuilder getOtherIndex();
		Index.IndexBuilder setCreditIndex(CreditIndex _CreditIndex);
		Index.IndexBuilder setEquityIndex(EquityIndex _EquityIndex);
		Index.IndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndex FloatingRateIndex0);
		Index.IndexBuilder setFloatingRateIndexValue(FloatingRateIndex FloatingRateIndex1);
		Index.IndexBuilder setForeignExchangeRateIndex(ForeignExchangeRateIndex _ForeignExchangeRateIndex);
		Index.IndexBuilder setOtherIndex(OtherIndex _OtherIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("CreditIndex"), processor, CreditIndex.CreditIndexBuilder.class, getCreditIndex());
			processRosetta(path.newSubPath("EquityIndex"), processor, EquityIndex.EquityIndexBuilder.class, getEquityIndex());
			processRosetta(path.newSubPath("FloatingRateIndex"), processor, FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("ForeignExchangeRateIndex"), processor, ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder.class, getForeignExchangeRateIndex());
			processRosetta(path.newSubPath("OtherIndex"), processor, OtherIndex.OtherIndexBuilder.class, getOtherIndex());
		}
		

		Index.IndexBuilder prune();
	}

	/*********************** Immutable Implementation of Index  ***********************/
	class IndexImpl implements Index {
		private final CreditIndex creditIndex;
		private final EquityIndex equityIndex;
		private final FieldWithMetaFloatingRateIndex floatingRateIndex;
		private final ForeignExchangeRateIndex foreignExchangeRateIndex;
		private final OtherIndex otherIndex;
		
		protected IndexImpl(Index.IndexBuilder builder) {
			this.creditIndex = ofNullable(builder.getCreditIndex()).map(f->f.build()).orElse(null);
			this.equityIndex = ofNullable(builder.getEquityIndex()).map(f->f.build()).orElse(null);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.foreignExchangeRateIndex = ofNullable(builder.getForeignExchangeRateIndex()).map(f->f.build()).orElse(null);
			this.otherIndex = ofNullable(builder.getOtherIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("CreditIndex")
		public CreditIndex getCreditIndex() {
			return creditIndex;
		}
		
		@Override
		@RosettaAttribute("EquityIndex")
		public EquityIndex getEquityIndex() {
			return equityIndex;
		}
		
		@Override
		@RosettaAttribute("FloatingRateIndex")
		public FieldWithMetaFloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("ForeignExchangeRateIndex")
		public ForeignExchangeRateIndex getForeignExchangeRateIndex() {
			return foreignExchangeRateIndex;
		}
		
		@Override
		@RosettaAttribute("OtherIndex")
		public OtherIndex getOtherIndex() {
			return otherIndex;
		}
		
		@Override
		public Index build() {
			return this;
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			Index.IndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Index.IndexBuilder builder) {
			ofNullable(getCreditIndex()).ifPresent(builder::setCreditIndex);
			ofNullable(getEquityIndex()).ifPresent(builder::setEquityIndex);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getForeignExchangeRateIndex()).ifPresent(builder::setForeignExchangeRateIndex);
			ofNullable(getOtherIndex()).ifPresent(builder::setOtherIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(creditIndex, _that.getCreditIndex())) return false;
			if (!Objects.equals(equityIndex, _that.getEquityIndex())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(foreignExchangeRateIndex, _that.getForeignExchangeRateIndex())) return false;
			if (!Objects.equals(otherIndex, _that.getOtherIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditIndex != null ? creditIndex.hashCode() : 0);
			_result = 31 * _result + (equityIndex != null ? equityIndex.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (foreignExchangeRateIndex != null ? foreignExchangeRateIndex.hashCode() : 0);
			_result = 31 * _result + (otherIndex != null ? otherIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Index {" +
				"CreditIndex=" + this.creditIndex + ", " +
				"EquityIndex=" + this.equityIndex + ", " +
				"FloatingRateIndex=" + this.floatingRateIndex + ", " +
				"ForeignExchangeRateIndex=" + this.foreignExchangeRateIndex + ", " +
				"OtherIndex=" + this.otherIndex +
			'}';
		}
	}

	/*********************** Builder Implementation of Index  ***********************/
	class IndexBuilderImpl implements Index.IndexBuilder {
	
		protected CreditIndex.CreditIndexBuilder creditIndex;
		protected EquityIndex.EquityIndexBuilder equityIndex;
		protected FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder floatingRateIndex;
		protected ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder foreignExchangeRateIndex;
		protected OtherIndex.OtherIndexBuilder otherIndex;
	
		public IndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("CreditIndex")
		public CreditIndex.CreditIndexBuilder getCreditIndex() {
			return creditIndex;
		}
		
		@Override
		public CreditIndex.CreditIndexBuilder getOrCreateCreditIndex() {
			CreditIndex.CreditIndexBuilder result;
			if (creditIndex!=null) {
				result = creditIndex;
			}
			else {
				result = creditIndex = CreditIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("EquityIndex")
		public EquityIndex.EquityIndexBuilder getEquityIndex() {
			return equityIndex;
		}
		
		@Override
		public EquityIndex.EquityIndexBuilder getOrCreateEquityIndex() {
			EquityIndex.EquityIndexBuilder result;
			if (equityIndex!=null) {
				result = equityIndex;
			}
			else {
				result = equityIndex = EquityIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FloatingRateIndex")
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FieldWithMetaFloatingRateIndex.builder();
				result.getOrCreateMeta().toBuilder().addKey(Key.builder().setScope("DOCUMENT"));
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ForeignExchangeRateIndex")
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder getForeignExchangeRateIndex() {
			return foreignExchangeRateIndex;
		}
		
		@Override
		public ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder getOrCreateForeignExchangeRateIndex() {
			ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder result;
			if (foreignExchangeRateIndex!=null) {
				result = foreignExchangeRateIndex;
			}
			else {
				result = foreignExchangeRateIndex = ForeignExchangeRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OtherIndex")
		public OtherIndex.OtherIndexBuilder getOtherIndex() {
			return otherIndex;
		}
		
		@Override
		public OtherIndex.OtherIndexBuilder getOrCreateOtherIndex() {
			OtherIndex.OtherIndexBuilder result;
			if (otherIndex!=null) {
				result = otherIndex;
			}
			else {
				result = otherIndex = OtherIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CreditIndex")
		public Index.IndexBuilder setCreditIndex(CreditIndex creditIndex) {
			this.creditIndex = creditIndex==null?null:creditIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("EquityIndex")
		public Index.IndexBuilder setEquityIndex(EquityIndex equityIndex) {
			this.equityIndex = equityIndex==null?null:equityIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("FloatingRateIndex")
		public Index.IndexBuilder setFloatingRateIndex(FieldWithMetaFloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		public Index.IndexBuilder setFloatingRateIndexValue(FloatingRateIndex floatingRateIndex) {
			this.getOrCreateFloatingRateIndex().setValue(floatingRateIndex);
			return this;
		}
		@Override
		@RosettaAttribute("ForeignExchangeRateIndex")
		public Index.IndexBuilder setForeignExchangeRateIndex(ForeignExchangeRateIndex foreignExchangeRateIndex) {
			this.foreignExchangeRateIndex = foreignExchangeRateIndex==null?null:foreignExchangeRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("OtherIndex")
		public Index.IndexBuilder setOtherIndex(OtherIndex otherIndex) {
			this.otherIndex = otherIndex==null?null:otherIndex.toBuilder();
			return this;
		}
		
		@Override
		public Index build() {
			return new Index.IndexImpl(this);
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder prune() {
			if (creditIndex!=null && !creditIndex.prune().hasData()) creditIndex = null;
			if (equityIndex!=null && !equityIndex.prune().hasData()) equityIndex = null;
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (foreignExchangeRateIndex!=null && !foreignExchangeRateIndex.prune().hasData()) foreignExchangeRateIndex = null;
			if (otherIndex!=null && !otherIndex.prune().hasData()) otherIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditIndex()!=null && getCreditIndex().hasData()) return true;
			if (getEquityIndex()!=null && getEquityIndex().hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getForeignExchangeRateIndex()!=null && getForeignExchangeRateIndex().hasData()) return true;
			if (getOtherIndex()!=null && getOtherIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Index.IndexBuilder o = (Index.IndexBuilder) other;
			
			merger.mergeRosetta(getCreditIndex(), o.getCreditIndex(), this::setCreditIndex);
			merger.mergeRosetta(getEquityIndex(), o.getEquityIndex(), this::setEquityIndex);
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getForeignExchangeRateIndex(), o.getForeignExchangeRateIndex(), this::setForeignExchangeRateIndex);
			merger.mergeRosetta(getOtherIndex(), o.getOtherIndex(), this::setOtherIndex);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(creditIndex, _that.getCreditIndex())) return false;
			if (!Objects.equals(equityIndex, _that.getEquityIndex())) return false;
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(foreignExchangeRateIndex, _that.getForeignExchangeRateIndex())) return false;
			if (!Objects.equals(otherIndex, _that.getOtherIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditIndex != null ? creditIndex.hashCode() : 0);
			_result = 31 * _result + (equityIndex != null ? equityIndex.hashCode() : 0);
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (foreignExchangeRateIndex != null ? foreignExchangeRateIndex.hashCode() : 0);
			_result = 31 * _result + (otherIndex != null ? otherIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBuilder {" +
				"CreditIndex=" + this.creditIndex + ", " +
				"EquityIndex=" + this.equityIndex + ", " +
				"FloatingRateIndex=" + this.floatingRateIndex + ", " +
				"ForeignExchangeRateIndex=" + this.foreignExchangeRateIndex + ", " +
				"OtherIndex=" + this.otherIndex +
			'}';
		}
	}
}
