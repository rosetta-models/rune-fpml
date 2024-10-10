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
import fpml.confirmation.OldTradeModel;
import fpml.confirmation.TradeNovationContentSequence0;
import fpml.confirmation.TradeNovationContentSequence0.TradeNovationContentSequence0Builder;
import fpml.confirmation.TradeNovationContentSequence0.TradeNovationContentSequence0BuilderImpl;
import fpml.confirmation.TradeNovationContentSequence0.TradeNovationContentSequence0Impl;
import fpml.confirmation.meta.TradeNovationContentSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNovationContentSequence0", builder=TradeNovationContentSequence0.TradeNovationContentSequence0BuilderImpl.class, version="${project.version}")
public interface TradeNovationContentSequence0 extends RosettaModelObject {

	TradeNovationContentSequence0Meta metaData = new TradeNovationContentSequence0Meta();

	/*********************** Getter Methods  ***********************/
	OldTradeModel getOldTradeModel();
	FeeTradeModel getFeeTradeModel();
	NewTradeModel getNewTradeModel();

	/*********************** Build Methods  ***********************/
	TradeNovationContentSequence0 build();
	
	TradeNovationContentSequence0.TradeNovationContentSequence0Builder toBuilder();
	
	static TradeNovationContentSequence0.TradeNovationContentSequence0Builder builder() {
		return new TradeNovationContentSequence0.TradeNovationContentSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNovationContentSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNovationContentSequence0> getType() {
		return TradeNovationContentSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("oldTradeModel"), processor, OldTradeModel.class, getOldTradeModel());
		processRosetta(path.newSubPath("feeTradeModel"), processor, FeeTradeModel.class, getFeeTradeModel());
		processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.class, getNewTradeModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNovationContentSequence0Builder extends TradeNovationContentSequence0, RosettaModelObjectBuilder {
		OldTradeModel.OldTradeModelBuilder getOrCreateOldTradeModel();
		OldTradeModel.OldTradeModelBuilder getOldTradeModel();
		FeeTradeModel.FeeTradeModelBuilder getOrCreateFeeTradeModel();
		FeeTradeModel.FeeTradeModelBuilder getFeeTradeModel();
		NewTradeModel.NewTradeModelBuilder getOrCreateNewTradeModel();
		NewTradeModel.NewTradeModelBuilder getNewTradeModel();
		TradeNovationContentSequence0.TradeNovationContentSequence0Builder setOldTradeModel(OldTradeModel oldTradeModel);
		TradeNovationContentSequence0.TradeNovationContentSequence0Builder setFeeTradeModel(FeeTradeModel feeTradeModel);
		TradeNovationContentSequence0.TradeNovationContentSequence0Builder setNewTradeModel(NewTradeModel newTradeModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("oldTradeModel"), processor, OldTradeModel.OldTradeModelBuilder.class, getOldTradeModel());
			processRosetta(path.newSubPath("feeTradeModel"), processor, FeeTradeModel.FeeTradeModelBuilder.class, getFeeTradeModel());
			processRosetta(path.newSubPath("newTradeModel"), processor, NewTradeModel.NewTradeModelBuilder.class, getNewTradeModel());
		}
		

		TradeNovationContentSequence0.TradeNovationContentSequence0Builder prune();
	}

	/*********************** Immutable Implementation of TradeNovationContentSequence0  ***********************/
	class TradeNovationContentSequence0Impl implements TradeNovationContentSequence0 {
		private final OldTradeModel oldTradeModel;
		private final FeeTradeModel feeTradeModel;
		private final NewTradeModel newTradeModel;
		
		protected TradeNovationContentSequence0Impl(TradeNovationContentSequence0.TradeNovationContentSequence0Builder builder) {
			this.oldTradeModel = ofNullable(builder.getOldTradeModel()).map(f->f.build()).orElse(null);
			this.feeTradeModel = ofNullable(builder.getFeeTradeModel()).map(f->f.build()).orElse(null);
			this.newTradeModel = ofNullable(builder.getNewTradeModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("oldTradeModel")
		public OldTradeModel getOldTradeModel() {
			return oldTradeModel;
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
		public TradeNovationContentSequence0 build() {
			return this;
		}
		
		@Override
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder toBuilder() {
			TradeNovationContentSequence0.TradeNovationContentSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNovationContentSequence0.TradeNovationContentSequence0Builder builder) {
			ofNullable(getOldTradeModel()).ifPresent(builder::setOldTradeModel);
			ofNullable(getFeeTradeModel()).ifPresent(builder::setFeeTradeModel);
			ofNullable(getNewTradeModel()).ifPresent(builder::setNewTradeModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNovationContentSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeModel, _that.getOldTradeModel())) return false;
			if (!Objects.equals(feeTradeModel, _that.getFeeTradeModel())) return false;
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeModel != null ? oldTradeModel.hashCode() : 0);
			_result = 31 * _result + (feeTradeModel != null ? feeTradeModel.hashCode() : 0);
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentSequence0 {" +
				"oldTradeModel=" + this.oldTradeModel + ", " +
				"feeTradeModel=" + this.feeTradeModel + ", " +
				"newTradeModel=" + this.newTradeModel +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNovationContentSequence0  ***********************/
	class TradeNovationContentSequence0BuilderImpl implements TradeNovationContentSequence0.TradeNovationContentSequence0Builder {
	
		protected OldTradeModel.OldTradeModelBuilder oldTradeModel;
		protected FeeTradeModel.FeeTradeModelBuilder feeTradeModel;
		protected NewTradeModel.NewTradeModelBuilder newTradeModel;
	
		public TradeNovationContentSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("oldTradeModel")
		public OldTradeModel.OldTradeModelBuilder getOldTradeModel() {
			return oldTradeModel;
		}
		
		@Override
		public OldTradeModel.OldTradeModelBuilder getOrCreateOldTradeModel() {
			OldTradeModel.OldTradeModelBuilder result;
			if (oldTradeModel!=null) {
				result = oldTradeModel;
			}
			else {
				result = oldTradeModel = OldTradeModel.builder();
			}
			
			return result;
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
		@RosettaAttribute("oldTradeModel")
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder setOldTradeModel(OldTradeModel oldTradeModel) {
			this.oldTradeModel = oldTradeModel==null?null:oldTradeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("feeTradeModel")
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder setFeeTradeModel(FeeTradeModel feeTradeModel) {
			this.feeTradeModel = feeTradeModel==null?null:feeTradeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("newTradeModel")
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder setNewTradeModel(NewTradeModel newTradeModel) {
			this.newTradeModel = newTradeModel==null?null:newTradeModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeNovationContentSequence0 build() {
			return new TradeNovationContentSequence0.TradeNovationContentSequence0Impl(this);
		}
		
		@Override
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder prune() {
			if (oldTradeModel!=null && !oldTradeModel.prune().hasData()) oldTradeModel = null;
			if (feeTradeModel!=null && !feeTradeModel.prune().hasData()) feeTradeModel = null;
			if (newTradeModel!=null && !newTradeModel.prune().hasData()) newTradeModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOldTradeModel()!=null && getOldTradeModel().hasData()) return true;
			if (getFeeTradeModel()!=null && getFeeTradeModel().hasData()) return true;
			if (getNewTradeModel()!=null && getNewTradeModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNovationContentSequence0.TradeNovationContentSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNovationContentSequence0.TradeNovationContentSequence0Builder o = (TradeNovationContentSequence0.TradeNovationContentSequence0Builder) other;
			
			merger.mergeRosetta(getOldTradeModel(), o.getOldTradeModel(), this::setOldTradeModel);
			merger.mergeRosetta(getFeeTradeModel(), o.getFeeTradeModel(), this::setFeeTradeModel);
			merger.mergeRosetta(getNewTradeModel(), o.getNewTradeModel(), this::setNewTradeModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNovationContentSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(oldTradeModel, _that.getOldTradeModel())) return false;
			if (!Objects.equals(feeTradeModel, _that.getFeeTradeModel())) return false;
			if (!Objects.equals(newTradeModel, _that.getNewTradeModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (oldTradeModel != null ? oldTradeModel.hashCode() : 0);
			_result = 31 * _result + (feeTradeModel != null ? feeTradeModel.hashCode() : 0);
			_result = 31 * _result + (newTradeModel != null ? newTradeModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNovationContentSequence0Builder {" +
				"oldTradeModel=" + this.oldTradeModel + ", " +
				"feeTradeModel=" + this.feeTradeModel + ", " +
				"newTradeModel=" + this.newTradeModel +
			'}';
		}
	}
}
