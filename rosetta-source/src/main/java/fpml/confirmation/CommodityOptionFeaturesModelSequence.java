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
import fpml.confirmation.CommodityAsianModel;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import fpml.confirmation.CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder;
import fpml.confirmation.CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilderImpl;
import fpml.confirmation.CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceImpl;
import fpml.confirmation.meta.CommodityOptionFeaturesModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityOptionFeaturesModelSequence", builder=CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityOptionFeaturesModelSequence extends RosettaModelObject {

	CommodityOptionFeaturesModelSequenceMeta metaData = new CommodityOptionFeaturesModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	CommodityAsianModel getCommodityAsianModel();
	/**
	 * Defines a commodity option barrier product feature.
	 */
	CommodityBarrier getBarrier();

	/*********************** Build Methods  ***********************/
	CommodityOptionFeaturesModelSequence build();
	
	CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder toBuilder();
	
	static CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder builder() {
		return new CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityOptionFeaturesModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityOptionFeaturesModelSequence> getType() {
		return CommodityOptionFeaturesModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodityAsianModel"), processor, CommodityAsianModel.class, getCommodityAsianModel());
		processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityOptionFeaturesModelSequenceBuilder extends CommodityOptionFeaturesModelSequence, RosettaModelObjectBuilder {
		CommodityAsianModel.CommodityAsianModelBuilder getOrCreateCommodityAsianModel();
		CommodityAsianModel.CommodityAsianModelBuilder getCommodityAsianModel();
		CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier();
		CommodityBarrier.CommodityBarrierBuilder getBarrier();
		CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder setCommodityAsianModel(CommodityAsianModel commodityAsianModel);
		CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder setBarrier(CommodityBarrier barrier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodityAsianModel"), processor, CommodityAsianModel.CommodityAsianModelBuilder.class, getCommodityAsianModel());
			processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.CommodityBarrierBuilder.class, getBarrier());
		}
		

		CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityOptionFeaturesModelSequence  ***********************/
	class CommodityOptionFeaturesModelSequenceImpl implements CommodityOptionFeaturesModelSequence {
		private final CommodityAsianModel commodityAsianModel;
		private final CommodityBarrier barrier;
		
		protected CommodityOptionFeaturesModelSequenceImpl(CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder builder) {
			this.commodityAsianModel = ofNullable(builder.getCommodityAsianModel()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityAsianModel")
		public CommodityAsianModel getCommodityAsianModel() {
			return commodityAsianModel;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public CommodityBarrier getBarrier() {
			return barrier;
		}
		
		@Override
		public CommodityOptionFeaturesModelSequence build() {
			return this;
		}
		
		@Override
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder toBuilder() {
			CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder builder) {
			ofNullable(getCommodityAsianModel()).ifPresent(builder::setCommodityAsianModel);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityOptionFeaturesModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityAsianModel, _that.getCommodityAsianModel())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityAsianModel != null ? commodityAsianModel.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionFeaturesModelSequence {" +
				"commodityAsianModel=" + this.commodityAsianModel + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityOptionFeaturesModelSequence  ***********************/
	class CommodityOptionFeaturesModelSequenceBuilderImpl implements CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder {
	
		protected CommodityAsianModel.CommodityAsianModelBuilder commodityAsianModel;
		protected CommodityBarrier.CommodityBarrierBuilder barrier;
	
		public CommodityOptionFeaturesModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityAsianModel")
		public CommodityAsianModel.CommodityAsianModelBuilder getCommodityAsianModel() {
			return commodityAsianModel;
		}
		
		@Override
		public CommodityAsianModel.CommodityAsianModelBuilder getOrCreateCommodityAsianModel() {
			CommodityAsianModel.CommodityAsianModelBuilder result;
			if (commodityAsianModel!=null) {
				result = commodityAsianModel;
			}
			else {
				result = commodityAsianModel = CommodityAsianModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public CommodityBarrier.CommodityBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier() {
			CommodityBarrier.CommodityBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = CommodityBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityAsianModel")
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder setCommodityAsianModel(CommodityAsianModel commodityAsianModel) {
			this.commodityAsianModel = commodityAsianModel==null?null:commodityAsianModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder setBarrier(CommodityBarrier barrier) {
			this.barrier = barrier==null?null:barrier.toBuilder();
			return this;
		}
		
		@Override
		public CommodityOptionFeaturesModelSequence build() {
			return new CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceImpl(this);
		}
		
		@Override
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder prune() {
			if (commodityAsianModel!=null && !commodityAsianModel.prune().hasData()) commodityAsianModel = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodityAsianModel()!=null && getCommodityAsianModel().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder o = (CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder) other;
			
			merger.mergeRosetta(getCommodityAsianModel(), o.getCommodityAsianModel(), this::setCommodityAsianModel);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityOptionFeaturesModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(commodityAsianModel, _that.getCommodityAsianModel())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodityAsianModel != null ? commodityAsianModel.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionFeaturesModelSequenceBuilder {" +
				"commodityAsianModel=" + this.commodityAsianModel + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}
}
