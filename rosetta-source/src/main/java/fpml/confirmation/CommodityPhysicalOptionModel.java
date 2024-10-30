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
import fpml.confirmation.CommodityForward;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder;
import fpml.confirmation.CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilderImpl;
import fpml.confirmation.CommodityPhysicalOptionModel.CommodityPhysicalOptionModelImpl;
import fpml.confirmation.CommoditySwaptionUnderlying;
import fpml.confirmation.meta.CommodityPhysicalOptionModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items specific to financially-settled commodity options.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPhysicalOptionModel", builder=CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPhysicalOptionModel extends RosettaModelObject {

	CommodityPhysicalOptionModelMeta metaData = new CommodityPhysicalOptionModelMeta();

	/*********************** Getter Methods  ***********************/
	CommoditySwaptionUnderlying getCommoditySwap();
	CommodityForward getCommodityForward();
	/**
	 * The parameters for defining how the commodity option can be exercised into a physical transaction.
	 */
	CommodityPhysicalExercise getPhysicalExercise();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalOptionModel build();
	
	CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder toBuilder();
	
	static CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder builder() {
		return new CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalOptionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalOptionModel> getType() {
		return CommodityPhysicalOptionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.class, getCommoditySwap());
		processRosetta(path.newSubPath("commodityForward"), processor, CommodityForward.class, getCommodityForward());
		processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.class, getPhysicalExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalOptionModelBuilder extends CommodityPhysicalOptionModel, RosettaModelObjectBuilder {
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap();
		CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap();
		CommodityForward.CommodityForwardBuilder getOrCreateCommodityForward();
		CommodityForward.CommodityForwardBuilder getCommodityForward();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise();
		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setCommoditySwap(CommoditySwaptionUnderlying commoditySwap);
		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setCommodityForward(CommodityForward commodityForward);
		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder.class, getCommoditySwap());
			processRosetta(path.newSubPath("commodityForward"), processor, CommodityForward.CommodityForwardBuilder.class, getCommodityForward());
			processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder.class, getPhysicalExercise());
		}
		

		CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalOptionModel  ***********************/
	class CommodityPhysicalOptionModelImpl implements CommodityPhysicalOptionModel {
		private final CommoditySwaptionUnderlying commoditySwap;
		private final CommodityForward commodityForward;
		private final CommodityPhysicalExercise physicalExercise;
		
		protected CommodityPhysicalOptionModelImpl(CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder builder) {
			this.commoditySwap = ofNullable(builder.getCommoditySwap()).map(f->f.build()).orElse(null);
			this.commodityForward = ofNullable(builder.getCommodityForward()).map(f->f.build()).orElse(null);
			this.physicalExercise = ofNullable(builder.getPhysicalExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		public CommoditySwaptionUnderlying getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		@RosettaAttribute("commodityForward")
		public CommodityForward getCommodityForward() {
			return commodityForward;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		public CommodityPhysicalExercise getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		public CommodityPhysicalOptionModel build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder toBuilder() {
			CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder builder) {
			ofNullable(getCommoditySwap()).ifPresent(builder::setCommoditySwap);
			ofNullable(getCommodityForward()).ifPresent(builder::setCommodityForward);
			ofNullable(getPhysicalExercise()).ifPresent(builder::setPhysicalExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(commodityForward, _that.getCommodityForward())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (commodityForward != null ? commodityForward.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalOptionModel {" +
				"commoditySwap=" + this.commoditySwap + ", " +
				"commodityForward=" + this.commodityForward + ", " +
				"physicalExercise=" + this.physicalExercise +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalOptionModel  ***********************/
	class CommodityPhysicalOptionModelBuilderImpl implements CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder {
	
		protected CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder commoditySwap;
		protected CommodityForward.CommodityForwardBuilder commodityForward;
		protected CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder physicalExercise;
	
		public CommodityPhysicalOptionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commoditySwap")
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		public CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder getOrCreateCommoditySwap() {
			CommoditySwaptionUnderlying.CommoditySwaptionUnderlyingBuilder result;
			if (commoditySwap!=null) {
				result = commoditySwap;
			}
			else {
				result = commoditySwap = CommoditySwaptionUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityForward")
		public CommodityForward.CommodityForwardBuilder getCommodityForward() {
			return commodityForward;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder getOrCreateCommodityForward() {
			CommodityForward.CommodityForwardBuilder result;
			if (commodityForward!=null) {
				result = commodityForward;
			}
			else {
				result = commodityForward = CommodityForward.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise() {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder result;
			if (physicalExercise!=null) {
				result = physicalExercise;
			}
			else {
				result = physicalExercise = CommodityPhysicalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commoditySwap")
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setCommoditySwap(CommoditySwaptionUnderlying commoditySwap) {
			this.commoditySwap = commoditySwap==null?null:commoditySwap.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityForward")
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setCommodityForward(CommodityForward commodityForward) {
			this.commodityForward = commodityForward==null?null:commodityForward.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalExercise")
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise) {
			this.physicalExercise = physicalExercise==null?null:physicalExercise.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalOptionModel build() {
			return new CommodityPhysicalOptionModel.CommodityPhysicalOptionModelImpl(this);
		}
		
		@Override
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder prune() {
			if (commoditySwap!=null && !commoditySwap.prune().hasData()) commoditySwap = null;
			if (commodityForward!=null && !commodityForward.prune().hasData()) commodityForward = null;
			if (physicalExercise!=null && !physicalExercise.prune().hasData()) physicalExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommoditySwap()!=null && getCommoditySwap().hasData()) return true;
			if (getCommodityForward()!=null && getCommodityForward().hasData()) return true;
			if (getPhysicalExercise()!=null && getPhysicalExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder o = (CommodityPhysicalOptionModel.CommodityPhysicalOptionModelBuilder) other;
			
			merger.mergeRosetta(getCommoditySwap(), o.getCommoditySwap(), this::setCommoditySwap);
			merger.mergeRosetta(getCommodityForward(), o.getCommodityForward(), this::setCommodityForward);
			merger.mergeRosetta(getPhysicalExercise(), o.getPhysicalExercise(), this::setPhysicalExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalOptionModel _that = getType().cast(o);
		
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(commodityForward, _that.getCommodityForward())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (commodityForward != null ? commodityForward.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalOptionModelBuilder {" +
				"commoditySwap=" + this.commoditySwap + ", " +
				"commodityForward=" + this.commodityForward + ", " +
				"physicalExercise=" + this.physicalExercise +
			'}';
		}
	}
}
