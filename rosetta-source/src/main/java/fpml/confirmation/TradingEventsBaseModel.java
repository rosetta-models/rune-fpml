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
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.TradingEventsBaseModel.TradingEventsBaseModelBuilder;
import fpml.confirmation.TradingEventsBaseModel.TradingEventsBaseModelBuilderImpl;
import fpml.confirmation.TradingEventsBaseModel.TradingEventsBaseModelImpl;
import fpml.confirmation.TradingEventsBaseModelSequence;
import fpml.confirmation.meta.TradingEventsBaseModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information about a trading event that represents a new trading activity (on a newly-created trade or package of trades), or in some cases the a representation of the trade&#39;s current state..
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradingEventsBaseModel", builder=TradingEventsBaseModel.TradingEventsBaseModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradingEventsBaseModel extends RosettaModelObject {

	TradingEventsBaseModelMeta metaData = new TradingEventsBaseModelMeta();

	/*********************** Getter Methods  ***********************/
	TradePackage getTradePackage();
	TradingEventsBaseModelSequence getTradingEventsBaseModelSequence();

	/*********************** Build Methods  ***********************/
	TradingEventsBaseModel build();
	
	TradingEventsBaseModel.TradingEventsBaseModelBuilder toBuilder();
	
	static TradingEventsBaseModel.TradingEventsBaseModelBuilder builder() {
		return new TradingEventsBaseModel.TradingEventsBaseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingEventsBaseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingEventsBaseModel> getType() {
		return TradingEventsBaseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("tradingEventsBaseModelSequence"), processor, TradingEventsBaseModelSequence.class, getTradingEventsBaseModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingEventsBaseModelBuilder extends TradingEventsBaseModel, RosettaModelObjectBuilder {
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		TradePackage.TradePackageBuilder getTradePackage();
		TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder getOrCreateTradingEventsBaseModelSequence();
		TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder getTradingEventsBaseModelSequence();
		TradingEventsBaseModel.TradingEventsBaseModelBuilder setTradePackage(TradePackage tradePackage);
		TradingEventsBaseModel.TradingEventsBaseModelBuilder setTradingEventsBaseModelSequence(TradingEventsBaseModelSequence tradingEventsBaseModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("tradingEventsBaseModelSequence"), processor, TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder.class, getTradingEventsBaseModelSequence());
		}
		

		TradingEventsBaseModel.TradingEventsBaseModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradingEventsBaseModel  ***********************/
	class TradingEventsBaseModelImpl implements TradingEventsBaseModel {
		private final TradePackage tradePackage;
		private final TradingEventsBaseModelSequence tradingEventsBaseModelSequence;
		
		protected TradingEventsBaseModelImpl(TradingEventsBaseModel.TradingEventsBaseModelBuilder builder) {
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.tradingEventsBaseModelSequence = ofNullable(builder.getTradingEventsBaseModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModelSequence")
		public TradingEventsBaseModelSequence getTradingEventsBaseModelSequence() {
			return tradingEventsBaseModelSequence;
		}
		
		@Override
		public TradingEventsBaseModel build() {
			return this;
		}
		
		@Override
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder toBuilder() {
			TradingEventsBaseModel.TradingEventsBaseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingEventsBaseModel.TradingEventsBaseModelBuilder builder) {
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getTradingEventsBaseModelSequence()).ifPresent(builder::setTradingEventsBaseModelSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(tradingEventsBaseModelSequence, _that.getTradingEventsBaseModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (tradingEventsBaseModelSequence != null ? tradingEventsBaseModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsBaseModel {" +
				"tradePackage=" + this.tradePackage + ", " +
				"tradingEventsBaseModelSequence=" + this.tradingEventsBaseModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingEventsBaseModel  ***********************/
	class TradingEventsBaseModelBuilderImpl implements TradingEventsBaseModel.TradingEventsBaseModelBuilder {
	
		protected TradePackage.TradePackageBuilder tradePackage;
		protected TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder tradingEventsBaseModelSequence;
	
		public TradingEventsBaseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradePackage")
		public TradePackage.TradePackageBuilder getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradePackage.TradePackageBuilder getOrCreateTradePackage() {
			TradePackage.TradePackageBuilder result;
			if (tradePackage!=null) {
				result = tradePackage;
			}
			else {
				result = tradePackage = TradePackage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradingEventsBaseModelSequence")
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder getTradingEventsBaseModelSequence() {
			return tradingEventsBaseModelSequence;
		}
		
		@Override
		public TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder getOrCreateTradingEventsBaseModelSequence() {
			TradingEventsBaseModelSequence.TradingEventsBaseModelSequenceBuilder result;
			if (tradingEventsBaseModelSequence!=null) {
				result = tradingEventsBaseModelSequence;
			}
			else {
				result = tradingEventsBaseModelSequence = TradingEventsBaseModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder setTradePackage(TradePackage tradePackage) {
			this.tradePackage = tradePackage==null?null:tradePackage.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsBaseModelSequence")
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder setTradingEventsBaseModelSequence(TradingEventsBaseModelSequence tradingEventsBaseModelSequence) {
			this.tradingEventsBaseModelSequence = tradingEventsBaseModelSequence==null?null:tradingEventsBaseModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public TradingEventsBaseModel build() {
			return new TradingEventsBaseModel.TradingEventsBaseModelImpl(this);
		}
		
		@Override
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder prune() {
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			if (tradingEventsBaseModelSequence!=null && !tradingEventsBaseModelSequence.prune().hasData()) tradingEventsBaseModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getTradingEventsBaseModelSequence()!=null && getTradingEventsBaseModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingEventsBaseModel.TradingEventsBaseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingEventsBaseModel.TradingEventsBaseModelBuilder o = (TradingEventsBaseModel.TradingEventsBaseModelBuilder) other;
			
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getTradingEventsBaseModelSequence(), o.getTradingEventsBaseModelSequence(), this::setTradingEventsBaseModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(tradingEventsBaseModelSequence, _that.getTradingEventsBaseModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (tradingEventsBaseModelSequence != null ? tradingEventsBaseModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingEventsBaseModelBuilder {" +
				"tradePackage=" + this.tradePackage + ", " +
				"tradingEventsBaseModelSequence=" + this.tradingEventsBaseModelSequence +
			'}';
		}
	}
}
