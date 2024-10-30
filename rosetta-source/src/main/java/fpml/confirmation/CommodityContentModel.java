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
import fpml.confirmation.CommodityBullionSettlementDisruptionEnum;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityContentModel.CommodityContentModelBuilder;
import fpml.confirmation.CommodityContentModel.CommodityContentModelBuilderImpl;
import fpml.confirmation.CommodityContentModel.CommodityContentModelImpl;
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.Rounding;
import fpml.confirmation.meta.CommodityContentModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items common to all Commodity Transactions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityContentModel", builder=CommodityContentModel.CommodityContentModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityContentModel extends RosettaModelObject {

	CommodityContentModelMeta metaData = new CommodityContentModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 */
	Boolean getCommonPricing();
	/**
	 * Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 */
	CommodityMarketDisruption getMarketDisruption();
	/**
	 * Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 */
	CommodityBullionSettlementDisruptionEnum getSettlementDisruption();
	/**
	 * Rounding direction and precision for amounts.
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	CommodityContentModel build();
	
	CommodityContentModel.CommodityContentModelBuilder toBuilder();
	
	static CommodityContentModel.CommodityContentModelBuilder builder() {
		return new CommodityContentModel.CommodityContentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityContentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityContentModel> getType() {
		return CommodityContentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityContentModelBuilder extends CommodityContentModel, RosettaModelObjectBuilder {
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption();
		Rounding.RoundingBuilder getOrCreateRounding();
		Rounding.RoundingBuilder getRounding();
		CommodityContentModel.CommodityContentModelBuilder setCommonPricing(Boolean commonPricing);
		CommodityContentModel.CommodityContentModelBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommodityContentModel.CommodityContentModelBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommodityContentModel.CommodityContentModelBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommodityContentModel.CommodityContentModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityContentModel  ***********************/
	class CommodityContentModelImpl implements CommodityContentModel {
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommodityContentModelImpl(CommodityContentModel.CommodityContentModelBuilder builder) {
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		public CommodityMarketDisruption getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public CommodityContentModel build() {
			return this;
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder toBuilder() {
			CommodityContentModel.CommodityContentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityContentModel.CommodityContentModelBuilder builder) {
			ofNullable(getCommonPricing()).ifPresent(builder::setCommonPricing);
			ofNullable(getMarketDisruption()).ifPresent(builder::setMarketDisruption);
			ofNullable(getSettlementDisruption()).ifPresent(builder::setSettlementDisruption);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityContentModel _that = getType().cast(o);
		
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityContentModel {" +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityContentModel  ***********************/
	class CommodityContentModelBuilderImpl implements CommodityContentModel.CommodityContentModelBuilder {
	
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
	
		public CommodityContentModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder result;
			if (marketDisruption!=null) {
				result = marketDisruption;
			}
			else {
				result = marketDisruption = CommodityMarketDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		public CommodityContentModel.CommodityContentModelBuilder setCommonPricing(Boolean commonPricing) {
			this.commonPricing = commonPricing==null?null:commonPricing;
			return this;
		}
		@Override
		@RosettaAttribute("marketDisruption")
		public CommodityContentModel.CommodityContentModelBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption) {
			this.marketDisruption = marketDisruption==null?null:marketDisruption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDisruption")
		public CommodityContentModel.CommodityContentModelBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption) {
			this.settlementDisruption = settlementDisruption==null?null:settlementDisruption;
			return this;
		}
		@Override
		@RosettaAttribute("rounding")
		public CommodityContentModel.CommodityContentModelBuilder setRounding(Rounding rounding) {
			this.rounding = rounding==null?null:rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommodityContentModel build() {
			return new CommodityContentModel.CommodityContentModelImpl(this);
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityContentModel.CommodityContentModelBuilder prune() {
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityContentModel.CommodityContentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityContentModel.CommodityContentModelBuilder o = (CommodityContentModel.CommodityContentModelBuilder) other;
			
			merger.mergeRosetta(getMarketDisruption(), o.getMarketDisruption(), this::setMarketDisruption);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getCommonPricing(), o.getCommonPricing(), this::setCommonPricing);
			merger.mergeBasic(getSettlementDisruption(), o.getSettlementDisruption(), this::setSettlementDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityContentModel _that = getType().cast(o);
		
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityContentModelBuilder {" +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}';
		}
	}
}
