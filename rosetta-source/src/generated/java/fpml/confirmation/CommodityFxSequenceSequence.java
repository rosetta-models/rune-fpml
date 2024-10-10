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
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityFxSequenceSequence;
import fpml.confirmation.CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder;
import fpml.confirmation.CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilderImpl;
import fpml.confirmation.CommodityFxSequenceSequence.CommodityFxSequenceSequenceImpl;
import fpml.confirmation.CommodityFxSequenceSequenceSequence;
import fpml.confirmation.meta.CommodityFxSequenceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFxSequenceSequence", builder=CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityFxSequenceSequence extends RosettaModelObject {

	CommodityFxSequenceSequenceMeta metaData = new CommodityFxSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	CommodityFxSequenceSequenceSequence getCommodityFxSequenceSequenceSequence();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();

	/*********************** Build Methods  ***********************/
	CommodityFxSequenceSequence build();
	
	CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder toBuilder();
	
	static CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder builder() {
		return new CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFxSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFxSequenceSequence> getType() {
		return CommodityFxSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityFxSequenceSequenceSequence"), processor, CommodityFxSequenceSequenceSequence.class, getCommodityFxSequenceSequenceSequence());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxSequenceSequenceBuilder extends CommodityFxSequenceSequence, RosettaModelObjectBuilder {
		CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder getOrCreateCommodityFxSequenceSequenceSequence();
		CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder getCommodityFxSequenceSequenceSequence();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder setCommodityFxSequenceSequenceSequence(CommodityFxSequenceSequenceSequence commodityFxSequenceSequenceSequence);
		CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityFxSequenceSequenceSequence"), processor, CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder.class, getCommodityFxSequenceSequenceSequence());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
		}
		

		CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFxSequenceSequence  ***********************/
	class CommodityFxSequenceSequenceImpl implements CommodityFxSequenceSequence {
		private final CommodityFxSequenceSequenceSequence commodityFxSequenceSequenceSequence;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		
		protected CommodityFxSequenceSequenceImpl(CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder builder) {
			this.commodityFxSequenceSequenceSequence = ofNullable(builder.getCommodityFxSequenceSequenceSequence()).map(f->f.build()).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityFxSequenceSequenceSequence")
		public CommodityFxSequenceSequenceSequence getCommodityFxSequenceSequenceSequence() {
			return commodityFxSequenceSequenceSequence;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityFxSequenceSequence build() {
			return this;
		}
		
		@Override
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder toBuilder() {
			CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder builder) {
			ofNullable(getCommodityFxSequenceSequenceSequence()).ifPresent(builder::setCommodityFxSequenceSequenceSequence);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityFxSequenceSequenceSequence, _that.getCommodityFxSequenceSequenceSequence())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityFxSequenceSequenceSequence != null ? commodityFxSequenceSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequenceSequence {" +
				"commodityFxSequenceSequenceSequence=" + this.commodityFxSequenceSequenceSequence + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFxSequenceSequence  ***********************/
	class CommodityFxSequenceSequenceBuilderImpl implements CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder {
	
		protected CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder commodityFxSequenceSequenceSequence;
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
	
		public CommodityFxSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityFxSequenceSequenceSequence")
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder getCommodityFxSequenceSequenceSequence() {
			return commodityFxSequenceSequenceSequence;
		}
		
		@Override
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder getOrCreateCommodityFxSequenceSequenceSequence() {
			CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder result;
			if (commodityFxSequenceSequenceSequence!=null) {
				result = commodityFxSequenceSequenceSequence;
			}
			else {
				result = commodityFxSequenceSequenceSequence = CommodityFxSequenceSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel() {
			CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder result;
			if (commodityCalculationPeriodsPointerModel!=null) {
				result = commodityCalculationPeriodsPointerModel;
			}
			else {
				result = commodityCalculationPeriodsPointerModel = CommodityCalculationPeriodsPointerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFxSequenceSequenceSequence")
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder setCommodityFxSequenceSequenceSequence(CommodityFxSequenceSequenceSequence commodityFxSequenceSequenceSequence) {
			this.commodityFxSequenceSequenceSequence = commodityFxSequenceSequenceSequence==null?null:commodityFxSequenceSequenceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFxSequenceSequence build() {
			return new CommodityFxSequenceSequence.CommodityFxSequenceSequenceImpl(this);
		}
		
		@Override
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder prune() {
			if (commodityFxSequenceSequenceSequence!=null && !commodityFxSequenceSequenceSequence.prune().hasData()) commodityFxSequenceSequenceSequence = null;
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityFxSequenceSequenceSequence()!=null && getCommodityFxSequenceSequenceSequence().hasData()) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder o = (CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder) other;
			
			merger.mergeRosetta(getCommodityFxSequenceSequenceSequence(), o.getCommodityFxSequenceSequenceSequence(), this::setCommodityFxSequenceSequenceSequence);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityFxSequenceSequenceSequence, _that.getCommodityFxSequenceSequenceSequence())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityFxSequenceSequenceSequence != null ? commodityFxSequenceSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequenceSequenceBuilder {" +
				"commodityFxSequenceSequenceSequence=" + this.commodityFxSequenceSequenceSequence + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel +
			'}';
		}
	}
}
