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
import fpml.confirmation.TradeOrInfoModel.TradeOrInfoModelBuilder;
import fpml.confirmation.TradeOrInfoModel.TradeOrInfoModelBuilderImpl;
import fpml.confirmation.TradeOrInfoModel.TradeOrInfoModelImpl;
import fpml.confirmation.TradeOrInfoModelSequence;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.meta.TradeOrInfoModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows either details of an event or information about a trade to be provided. Typically this will be used in a response to a request.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeOrInfoModel", builder=TradeOrInfoModel.TradeOrInfoModelBuilderImpl.class, version="${project.version}")
public interface TradeOrInfoModel extends RosettaModelObject {

	TradeOrInfoModelMeta metaData = new TradeOrInfoModelMeta();

	/*********************** Getter Methods  ***********************/
	TradeOrInfoModelSequence getTradeOrInfoModelSequence();
	TradeReferenceInformationModel getTradeReferenceInformationModel();
	TradePackage getTradePackage();

	/*********************** Build Methods  ***********************/
	TradeOrInfoModel build();
	
	TradeOrInfoModel.TradeOrInfoModelBuilder toBuilder();
	
	static TradeOrInfoModel.TradeOrInfoModelBuilder builder() {
		return new TradeOrInfoModel.TradeOrInfoModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeOrInfoModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeOrInfoModel> getType() {
		return TradeOrInfoModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeOrInfoModelSequence"), processor, TradeOrInfoModelSequence.class, getTradeOrInfoModelSequence());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeOrInfoModelBuilder extends TradeOrInfoModel, RosettaModelObjectBuilder {
		TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder getOrCreateTradeOrInfoModelSequence();
		TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder getTradeOrInfoModelSequence();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		TradePackage.TradePackageBuilder getTradePackage();
		TradeOrInfoModel.TradeOrInfoModelBuilder setTradeOrInfoModelSequence(TradeOrInfoModelSequence tradeOrInfoModelSequence);
		TradeOrInfoModel.TradeOrInfoModelBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		TradeOrInfoModel.TradeOrInfoModelBuilder setTradePackage(TradePackage tradePackage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeOrInfoModelSequence"), processor, TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder.class, getTradeOrInfoModelSequence());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
		}
		

		TradeOrInfoModel.TradeOrInfoModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeOrInfoModel  ***********************/
	class TradeOrInfoModelImpl implements TradeOrInfoModel {
		private final TradeOrInfoModelSequence tradeOrInfoModelSequence;
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		private final TradePackage tradePackage;
		
		protected TradeOrInfoModelImpl(TradeOrInfoModel.TradeOrInfoModelBuilder builder) {
			this.tradeOrInfoModelSequence = ofNullable(builder.getTradeOrInfoModelSequence()).map(f->f.build()).orElse(null);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeOrInfoModelSequence")
		public TradeOrInfoModelSequence getTradeOrInfoModelSequence() {
			return tradeOrInfoModelSequence;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradeOrInfoModel build() {
			return this;
		}
		
		@Override
		public TradeOrInfoModel.TradeOrInfoModelBuilder toBuilder() {
			TradeOrInfoModel.TradeOrInfoModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeOrInfoModel.TradeOrInfoModelBuilder builder) {
			ofNullable(getTradeOrInfoModelSequence()).ifPresent(builder::setTradeOrInfoModelSequence);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrInfoModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeOrInfoModelSequence, _that.getTradeOrInfoModelSequence())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrInfoModelSequence != null ? tradeOrInfoModelSequence.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeOrInfoModel {" +
				"tradeOrInfoModelSequence=" + this.tradeOrInfoModelSequence + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"tradePackage=" + this.tradePackage +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeOrInfoModel  ***********************/
	class TradeOrInfoModelBuilderImpl implements TradeOrInfoModel.TradeOrInfoModelBuilder {
	
		protected TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder tradeOrInfoModelSequence;
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
		protected TradePackage.TradePackageBuilder tradePackage;
	
		public TradeOrInfoModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeOrInfoModelSequence")
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder getTradeOrInfoModelSequence() {
			return tradeOrInfoModelSequence;
		}
		
		@Override
		public TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder getOrCreateTradeOrInfoModelSequence() {
			TradeOrInfoModelSequence.TradeOrInfoModelSequenceBuilder result;
			if (tradeOrInfoModelSequence!=null) {
				result = tradeOrInfoModelSequence;
			}
			else {
				result = tradeOrInfoModelSequence = TradeOrInfoModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			if (tradeReferenceInformationModel!=null) {
				result = tradeReferenceInformationModel;
			}
			else {
				result = tradeReferenceInformationModel = TradeReferenceInformationModel.builder();
			}
			
			return result;
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
		@RosettaAttribute("tradeOrInfoModelSequence")
		public TradeOrInfoModel.TradeOrInfoModelBuilder setTradeOrInfoModelSequence(TradeOrInfoModelSequence tradeOrInfoModelSequence) {
			this.tradeOrInfoModelSequence = tradeOrInfoModelSequence==null?null:tradeOrInfoModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeOrInfoModel.TradeOrInfoModelBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradePackage")
		public TradeOrInfoModel.TradeOrInfoModelBuilder setTradePackage(TradePackage tradePackage) {
			this.tradePackage = tradePackage==null?null:tradePackage.toBuilder();
			return this;
		}
		
		@Override
		public TradeOrInfoModel build() {
			return new TradeOrInfoModel.TradeOrInfoModelImpl(this);
		}
		
		@Override
		public TradeOrInfoModel.TradeOrInfoModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeOrInfoModel.TradeOrInfoModelBuilder prune() {
			if (tradeOrInfoModelSequence!=null && !tradeOrInfoModelSequence.prune().hasData()) tradeOrInfoModelSequence = null;
			if (tradeReferenceInformationModel!=null && !tradeReferenceInformationModel.prune().hasData()) tradeReferenceInformationModel = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeOrInfoModelSequence()!=null && getTradeOrInfoModelSequence().hasData()) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeOrInfoModel.TradeOrInfoModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeOrInfoModel.TradeOrInfoModelBuilder o = (TradeOrInfoModel.TradeOrInfoModelBuilder) other;
			
			merger.mergeRosetta(getTradeOrInfoModelSequence(), o.getTradeOrInfoModelSequence(), this::setTradeOrInfoModelSequence);
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeOrInfoModel _that = getType().cast(o);
		
			if (!Objects.equals(tradeOrInfoModelSequence, _that.getTradeOrInfoModelSequence())) return false;
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeOrInfoModelSequence != null ? tradeOrInfoModelSequence.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeOrInfoModelBuilder {" +
				"tradeOrInfoModelSequence=" + this.tradeOrInfoModelSequence + ", " +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"tradePackage=" + this.tradePackage +
			'}';
		}
	}
}
