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
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.FeeTradeModel.FeeTradeModelBuilder;
import fpml.confirmation.FeeTradeModel.FeeTradeModelBuilderImpl;
import fpml.confirmation.FeeTradeModel.FeeTradeModelImpl;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.meta.FeeTradeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FeeTradeModel", builder=FeeTradeModel.FeeTradeModelBuilderImpl.class, version="${project.version}")
public interface FeeTradeModel extends RosettaModelObject {

	FeeTradeModelMeta metaData = new FeeTradeModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates a reference to the implied trade (the &quot;fee trade&quot;) that the associated novation fee based on. This is equivalent to the new trade that is created by the novation (between the transferee and the remaining party), but is between the transferor and the transferee.
	 */
	PartyTradeIdentifier getFeeTradeIdentifier();
	/**
	 * Indicates the original trade between the transferor and the remaining party.
	 */
	Trade getFeeTrade();

	/*********************** Build Methods  ***********************/
	FeeTradeModel build();
	
	FeeTradeModel.FeeTradeModelBuilder toBuilder();
	
	static FeeTradeModel.FeeTradeModelBuilder builder() {
		return new FeeTradeModel.FeeTradeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeTradeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeTradeModel> getType() {
		return FeeTradeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("feeTradeIdentifier"), processor, PartyTradeIdentifier.class, getFeeTradeIdentifier());
		processRosetta(path.newSubPath("feeTrade"), processor, Trade.class, getFeeTrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeTradeModelBuilder extends FeeTradeModel, RosettaModelObjectBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateFeeTradeIdentifier();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getFeeTradeIdentifier();
		Trade.TradeBuilder getOrCreateFeeTrade();
		Trade.TradeBuilder getFeeTrade();
		FeeTradeModel.FeeTradeModelBuilder setFeeTradeIdentifier(PartyTradeIdentifier feeTradeIdentifier);
		FeeTradeModel.FeeTradeModelBuilder setFeeTrade(Trade feeTrade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("feeTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getFeeTradeIdentifier());
			processRosetta(path.newSubPath("feeTrade"), processor, Trade.TradeBuilder.class, getFeeTrade());
		}
		

		FeeTradeModel.FeeTradeModelBuilder prune();
	}

	/*********************** Immutable Implementation of FeeTradeModel  ***********************/
	class FeeTradeModelImpl implements FeeTradeModel {
		private final PartyTradeIdentifier feeTradeIdentifier;
		private final Trade feeTrade;
		
		protected FeeTradeModelImpl(FeeTradeModel.FeeTradeModelBuilder builder) {
			this.feeTradeIdentifier = ofNullable(builder.getFeeTradeIdentifier()).map(f->f.build()).orElse(null);
			this.feeTrade = ofNullable(builder.getFeeTrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeTradeIdentifier")
		public PartyTradeIdentifier getFeeTradeIdentifier() {
			return feeTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("feeTrade")
		public Trade getFeeTrade() {
			return feeTrade;
		}
		
		@Override
		public FeeTradeModel build() {
			return this;
		}
		
		@Override
		public FeeTradeModel.FeeTradeModelBuilder toBuilder() {
			FeeTradeModel.FeeTradeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeTradeModel.FeeTradeModelBuilder builder) {
			ofNullable(getFeeTradeIdentifier()).ifPresent(builder::setFeeTradeIdentifier);
			ofNullable(getFeeTrade()).ifPresent(builder::setFeeTrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeTradeModel _that = getType().cast(o);
		
			if (!Objects.equals(feeTradeIdentifier, _that.getFeeTradeIdentifier())) return false;
			if (!Objects.equals(feeTrade, _that.getFeeTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeTradeIdentifier != null ? feeTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (feeTrade != null ? feeTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeTradeModel {" +
				"feeTradeIdentifier=" + this.feeTradeIdentifier + ", " +
				"feeTrade=" + this.feeTrade +
			'}';
		}
	}

	/*********************** Builder Implementation of FeeTradeModel  ***********************/
	class FeeTradeModelBuilderImpl implements FeeTradeModel.FeeTradeModelBuilder {
	
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder feeTradeIdentifier;
		protected Trade.TradeBuilder feeTrade;
	
		public FeeTradeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getFeeTradeIdentifier() {
			return feeTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateFeeTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (feeTradeIdentifier!=null) {
				result = feeTradeIdentifier;
			}
			else {
				result = feeTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeTrade")
		public Trade.TradeBuilder getFeeTrade() {
			return feeTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateFeeTrade() {
			Trade.TradeBuilder result;
			if (feeTrade!=null) {
				result = feeTrade;
			}
			else {
				result = feeTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeTradeIdentifier")
		public FeeTradeModel.FeeTradeModelBuilder setFeeTradeIdentifier(PartyTradeIdentifier feeTradeIdentifier) {
			this.feeTradeIdentifier = feeTradeIdentifier==null?null:feeTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeTrade")
		public FeeTradeModel.FeeTradeModelBuilder setFeeTrade(Trade feeTrade) {
			this.feeTrade = feeTrade==null?null:feeTrade.toBuilder();
			return this;
		}
		
		@Override
		public FeeTradeModel build() {
			return new FeeTradeModel.FeeTradeModelImpl(this);
		}
		
		@Override
		public FeeTradeModel.FeeTradeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeTradeModel.FeeTradeModelBuilder prune() {
			if (feeTradeIdentifier!=null && !feeTradeIdentifier.prune().hasData()) feeTradeIdentifier = null;
			if (feeTrade!=null && !feeTrade.prune().hasData()) feeTrade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeeTradeIdentifier()!=null && getFeeTradeIdentifier().hasData()) return true;
			if (getFeeTrade()!=null && getFeeTrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeTradeModel.FeeTradeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeeTradeModel.FeeTradeModelBuilder o = (FeeTradeModel.FeeTradeModelBuilder) other;
			
			merger.mergeRosetta(getFeeTradeIdentifier(), o.getFeeTradeIdentifier(), this::setFeeTradeIdentifier);
			merger.mergeRosetta(getFeeTrade(), o.getFeeTrade(), this::setFeeTrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeTradeModel _that = getType().cast(o);
		
			if (!Objects.equals(feeTradeIdentifier, _that.getFeeTradeIdentifier())) return false;
			if (!Objects.equals(feeTrade, _that.getFeeTrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeTradeIdentifier != null ? feeTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (feeTrade != null ? feeTrade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeTradeModelBuilder {" +
				"feeTradeIdentifier=" + this.feeTradeIdentifier + ", " +
				"feeTrade=" + this.feeTrade +
			'}';
		}
	}
}
