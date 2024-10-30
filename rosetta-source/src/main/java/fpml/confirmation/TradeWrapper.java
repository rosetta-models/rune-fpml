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
import fpml.confirmation.TradeOrInfoModel;
import fpml.confirmation.TradeWrapper;
import fpml.confirmation.TradeWrapper.TradeWrapperBuilder;
import fpml.confirmation.TradeWrapper.TradeWrapperBuilderImpl;
import fpml.confirmation.TradeWrapper.TradeWrapperImpl;
import fpml.confirmation.meta.TradeWrapperMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that contains a business event.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeWrapper", builder=TradeWrapper.TradeWrapperBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeWrapper extends RosettaModelObject {

	TradeWrapperMeta metaData = new TradeWrapperMeta();

	/*********************** Getter Methods  ***********************/
	TradeOrInfoModel getTradeOrInfoModel();

	/*********************** Build Methods  ***********************/
	TradeWrapper build();
	
	TradeWrapper.TradeWrapperBuilder toBuilder();
	
	static TradeWrapper.TradeWrapperBuilder builder() {
		return new TradeWrapper.TradeWrapperBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeWrapper> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeWrapper> getType() {
		return TradeWrapper.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeOrInfoModel"), processor, TradeOrInfoModel.class, getTradeOrInfoModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeWrapperBuilder extends TradeWrapper, RosettaModelObjectBuilder {
		TradeOrInfoModel.TradeOrInfoModelBuilder getOrCreateTradeOrInfoModel();
		TradeOrInfoModel.TradeOrInfoModelBuilder getTradeOrInfoModel();
		TradeWrapper.TradeWrapperBuilder setTradeOrInfoModel(TradeOrInfoModel tradeOrInfoModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeOrInfoModel"), processor, TradeOrInfoModel.TradeOrInfoModelBuilder.class, getTradeOrInfoModel());
		}
		

		TradeWrapper.TradeWrapperBuilder prune();
	}

	/*********************** Immutable Implementation of TradeWrapper  ***********************/
	class TradeWrapperImpl implements TradeWrapper {
		private final TradeOrInfoModel tradeOrInfoModel;
		
		protected TradeWrapperImpl(TradeWrapper.TradeWrapperBuilder builder) {
			this.tradeOrInfoModel = ofNullable(builder.getTradeOrInfoModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeOrInfoModel")
		public TradeOrInfoModel getTradeOrInfoModel() {
			return tradeOrInfoModel;
		}
		
		@Override
		public TradeWrapper build() {
			return this;
		}
		
		@Override
		public TradeWrapper.TradeWrapperBuilder toBuilder() {
			TradeWrapper.TradeWrapperBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeWrapper.TradeWrapperBuilder builder) {
			ofNullable(getTradeOrInfoModel()).ifPresent(builder::setTradeOrInfoModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWrapper _that = getType().cast(o);
		
			if (!Objects.equals(tradeOrInfoModel, _that.getTradeOrInfoModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrInfoModel != null ? tradeOrInfoModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWrapper {" +
				"tradeOrInfoModel=" + this.tradeOrInfoModel +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeWrapper  ***********************/
	class TradeWrapperBuilderImpl implements TradeWrapper.TradeWrapperBuilder {
	
		protected TradeOrInfoModel.TradeOrInfoModelBuilder tradeOrInfoModel;
	
		public TradeWrapperBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeOrInfoModel")
		public TradeOrInfoModel.TradeOrInfoModelBuilder getTradeOrInfoModel() {
			return tradeOrInfoModel;
		}
		
		@Override
		public TradeOrInfoModel.TradeOrInfoModelBuilder getOrCreateTradeOrInfoModel() {
			TradeOrInfoModel.TradeOrInfoModelBuilder result;
			if (tradeOrInfoModel!=null) {
				result = tradeOrInfoModel;
			}
			else {
				result = tradeOrInfoModel = TradeOrInfoModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeOrInfoModel")
		public TradeWrapper.TradeWrapperBuilder setTradeOrInfoModel(TradeOrInfoModel tradeOrInfoModel) {
			this.tradeOrInfoModel = tradeOrInfoModel==null?null:tradeOrInfoModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeWrapper build() {
			return new TradeWrapper.TradeWrapperImpl(this);
		}
		
		@Override
		public TradeWrapper.TradeWrapperBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWrapper.TradeWrapperBuilder prune() {
			if (tradeOrInfoModel!=null && !tradeOrInfoModel.prune().hasData()) tradeOrInfoModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeOrInfoModel()!=null && getTradeOrInfoModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeWrapper.TradeWrapperBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeWrapper.TradeWrapperBuilder o = (TradeWrapper.TradeWrapperBuilder) other;
			
			merger.mergeRosetta(getTradeOrInfoModel(), o.getTradeOrInfoModel(), this::setTradeOrInfoModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeWrapper _that = getType().cast(o);
		
			if (!Objects.equals(tradeOrInfoModel, _that.getTradeOrInfoModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrInfoModel != null ? tradeOrInfoModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeWrapperBuilder {" +
				"tradeOrInfoModel=" + this.tradeOrInfoModel +
			'}';
		}
	}
}
