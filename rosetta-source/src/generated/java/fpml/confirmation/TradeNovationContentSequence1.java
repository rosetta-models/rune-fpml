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
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.TradeNovationContentSequence1;
import fpml.confirmation.TradeNovationContentSequence1.TradeNovationContentSequence1Builder;
import fpml.confirmation.TradeNovationContentSequence1.TradeNovationContentSequence1BuilderImpl;
import fpml.confirmation.TradeNovationContentSequence1.TradeNovationContentSequence1Impl;
import fpml.confirmation.meta.TradeNovationContentSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNovationContentSequence1", builder=TradeNovationContentSequence1.TradeNovationContentSequence1BuilderImpl.class, version="${project.version}")
public interface TradeNovationContentSequence1 extends RosettaModelObject {

	TradeNovationContentSequence1Meta metaData = new TradeNovationContentSequence1Meta();

	/*********************** Getter Methods  ***********************/
	FeeTradeModel getFeeTradeModel();
	NewTradeModel getNewTradeModel();

	/*********************** Build Methods  ***********************/
	TradeNovationContentSequence1 build();
	
	TradeNovationContentSequence1.TradeNovationContentSequence1Builder toBuilder();
	
	static TradeNovationContentSequence1.TradeNovationContentSequence1Builder builder() {
		return new TradeNovationContentSequence1.TradeNovationContentSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNovationContentSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNovationContentSequence1> getType() {
		return TradeNovationContentSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("feeTradeModel"), processor, FeeTradeModel.class, getFeeTradeModel());
		processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.class, getNewTradeModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNovationContentSequence1Builder extends TradeNovationContentSequence1, RosettaModelObjectBuilder {
		FeeTradeModel.FeeTradeModelBuilder getOrCreateFeeTradeModel();
		FeeTradeModel.FeeTradeModelBuilder getFeeTradeModel();
		NewTradeModel.NewTradeModelBuilder getOrCreateNewTradeModel();
		NewTradeModel.NewTradeModelBuilder getNewTradeModel();
		TradeNovationContentSequence1.TradeNovationContentSequence1Builder setFeeTradeModel(FeeTradeModel feeTradeModel);
		TradeNovationContentSequence1.TradeNovationContentSequence1Builder setNewTradeModel(NewTradeModel newTradeModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("feeTradeModel"), processor, FeeTradeModel.FeeTradeModelBuilder.class, getFeeTradeModel());
			processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.NewTradeModelBuilder.class, getNewTradeModel());
		}
		

		TradeNovationContentSequence1.TradeNovationContentSequence1Builder prune();
	}

	/*********************** Immutable Implementation of TradeNovationContentSequence1  ***********************/
	class TradeNovationContentSequence1Impl implements TradeNovationContentSequence1 {
		private final FeeTradeModel feeTradeModel;
		private final NewTradeModel newTradeModel;
		
		protected TradeNovationContentSequence1Impl(TradeNovationContentSequence1.TradeNovationContentSequence1Builder builder) {
			this.feeTradeModel = ofNullable(builder.getFeeTradeModel()).map(f->f.build()).orElse(null);
			this.newTradeModel = ofNullable(builder.getNewTradeModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("feeTradeModel")
		public FeeTradeModel getFeeTradeModel() {
			return feeTradeModel;
		}
		
		@Override
		@RosettaAttribute("newTradeModel")
		public NewTradeModel getNewTradeModel() {
			return newTradeModel;
		}
		
		@Override
		public TradeNovationContentSequence1 build() {
			return this;
		}
		
		@Override
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder toBuilder() {
			TradeNovationContentSequence1.TradeNovationContentSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNovationContentSequence1.TradeNovationContentSequence1Builder builder) {
			ofNullable(getFeeTradeModel()).ifPresent(builder::setFeeTradeModel);
			ofNullable(getNewTradeModel()).ifPresent(builder::setNewTradeModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNovationContentSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(feeTradeModel, _that.getFeeTradeModel())) return false;
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeTradeModel != null ? feeTradeModel.hashCode() : 0);
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentSequence1 {" +
				"feeTradeModel=" + this.feeTradeModel + ", " +
				"newTradeModel=" + this.newTradeModel +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNovationContentSequence1  ***********************/
	class TradeNovationContentSequence1BuilderImpl implements TradeNovationContentSequence1.TradeNovationContentSequence1Builder {
	
		protected FeeTradeModel.FeeTradeModelBuilder feeTradeModel;
		protected NewTradeModel.NewTradeModelBuilder newTradeModel;
	
		public TradeNovationContentSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("feeTradeModel")
		public FeeTradeModel.FeeTradeModelBuilder getFeeTradeModel() {
			return feeTradeModel;
		}
		
		@Override
		public FeeTradeModel.FeeTradeModelBuilder getOrCreateFeeTradeModel() {
			FeeTradeModel.FeeTradeModelBuilder result;
			if (feeTradeModel!=null) {
				result = feeTradeModel;
			}
			else {
				result = feeTradeModel = FeeTradeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("newTradeModel")
		public NewTradeModel.NewTradeModelBuilder getNewTradeModel() {
			return newTradeModel;
		}
		
		@Override
		public NewTradeModel.NewTradeModelBuilder getOrCreateNewTradeModel() {
			NewTradeModel.NewTradeModelBuilder result;
			if (newTradeModel!=null) {
				result = newTradeModel;
			}
			else {
				result = newTradeModel = NewTradeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feeTradeModel")
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder setFeeTradeModel(FeeTradeModel feeTradeModel) {
			this.feeTradeModel = feeTradeModel==null?null:feeTradeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("newTradeModel")
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder setNewTradeModel(NewTradeModel newTradeModel) {
			this.newTradeModel = newTradeModel==null?null:newTradeModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeNovationContentSequence1 build() {
			return new TradeNovationContentSequence1.TradeNovationContentSequence1Impl(this);
		}
		
		@Override
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder prune() {
			if (feeTradeModel!=null && !feeTradeModel.prune().hasData()) feeTradeModel = null;
			if (newTradeModel!=null && !newTradeModel.prune().hasData()) newTradeModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFeeTradeModel()!=null && getFeeTradeModel().hasData()) return true;
			if (getNewTradeModel()!=null && getNewTradeModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContentSequence1.TradeNovationContentSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNovationContentSequence1.TradeNovationContentSequence1Builder o = (TradeNovationContentSequence1.TradeNovationContentSequence1Builder) other;
			
			merger.mergeRosetta(getFeeTradeModel(), o.getFeeTradeModel(), this::setFeeTradeModel);
			merger.mergeRosetta(getNewTradeModel(), o.getNewTradeModel(), this::setNewTradeModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNovationContentSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(feeTradeModel, _that.getFeeTradeModel())) return false;
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (feeTradeModel != null ? feeTradeModel.hashCode() : 0);
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentSequence1Builder {" +
				"feeTradeModel=" + this.feeTradeModel + ", " +
				"newTradeModel=" + this.newTradeModel +
			'}';
		}
	}
}
