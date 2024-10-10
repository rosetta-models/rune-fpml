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
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.CommoditySwaptionUnderlying;
import fpml.confirmation.CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder;
import fpml.confirmation.CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl;
import fpml.confirmation.CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingImpl;
import fpml.confirmation.meta.CommoditySwaptionUnderlyingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySwaptionUnderlying", builder=CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl.class, version="${project.version}")
public interface CommoditySwaptionUnderlying extends RosettaModelObject {

	CommoditySwaptionUnderlyingMeta metaData = new CommoditySwaptionUnderlyingMeta();

	/*********************** Getter Methods  ***********************/
	CommoditySwapDetailsModel getCommoditySwapDetailsModel();

	/*********************** Build Methods  ***********************/
	CommoditySwaptionUnderlying build();
	
	CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder();
	
	static CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder() {
		return new CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwaptionUnderlying> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySwaptionUnderlying> getType() {
		return CommoditySwaptionUnderlying.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commoditySwapDetailsModel"), processor, CommoditySwapDetailsModel.class, getCommoditySwapDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwaptionUnderlyingBuilder extends CommoditySwaptionUnderlying, RosettaModelObjectBuilder {
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getOrCreateCommoditySwapDetailsModel();
		CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getCommoditySwapDetailsModel();
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommoditySwapDetailsModel(CommoditySwapDetailsModel commoditySwapDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commoditySwapDetailsModel"), processor, CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder.class, getCommoditySwapDetailsModel());
		}
		

		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwaptionUnderlying  ***********************/
	class CommoditySwaptionUnderlyingImpl implements CommoditySwaptionUnderlying {
		private final CommoditySwapDetailsModel commoditySwapDetailsModel;
		
		protected CommoditySwaptionUnderlyingImpl(CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder) {
			this.commoditySwapDetailsModel = ofNullable(builder.getCommoditySwapDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwapDetailsModel getCommoditySwapDetailsModel() {
			return commoditySwapDetailsModel;
		}
		
		@Override
		public CommoditySwaptionUnderlying build() {
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder() {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder builder) {
			ofNullable(getCommoditySwapDetailsModel()).ifPresent(builder::setCommoditySwapDetailsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwaptionUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwapDetailsModel, _that.getCommoditySwapDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commoditySwapDetailsModel != null ? commoditySwapDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionUnderlying {" +
				"commoditySwapDetailsModel=" + this.commoditySwapDetailsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommoditySwaptionUnderlying  ***********************/
	class CommoditySwaptionUnderlyingBuilderImpl implements CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder {
	
		protected CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder commoditySwapDetailsModel;
	
		public CommoditySwaptionUnderlyingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getCommoditySwapDetailsModel() {
			return commoditySwapDetailsModel;
		}
		
		@Override
		public CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder getOrCreateCommoditySwapDetailsModel() {
			CommoditySwapDetailsModel.CommoditySwapDetailsModelBuilder result;
			if (commoditySwapDetailsModel!=null) {
				result = commoditySwapDetailsModel;
			}
			else {
				result = commoditySwapDetailsModel = CommoditySwapDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commoditySwapDetailsModel")
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder setCommoditySwapDetailsModel(CommoditySwapDetailsModel commoditySwapDetailsModel) {
			this.commoditySwapDetailsModel = commoditySwapDetailsModel==null?null:commoditySwapDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySwaptionUnderlying build() {
			return new CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingImpl(this);
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder prune() {
			if (commoditySwapDetailsModel!=null && !commoditySwapDetailsModel.prune().hasData()) commoditySwapDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommoditySwapDetailsModel()!=null && getCommoditySwapDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder o = (CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder) other;
			
			merger.mergeRosetta(getCommoditySwapDetailsModel(), o.getCommoditySwapDetailsModel(), this::setCommoditySwapDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommoditySwaptionUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwapDetailsModel, _that.getCommoditySwapDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commoditySwapDetailsModel != null ? commoditySwapDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySwaptionUnderlyingBuilder {" +
				"commoditySwapDetailsModel=" + this.commoditySwapDetailsModel +
			'}';
		}
	}
}
