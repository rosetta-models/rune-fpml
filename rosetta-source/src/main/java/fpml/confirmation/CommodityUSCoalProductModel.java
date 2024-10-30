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
import fpml.confirmation.CoalQualityAdjustments;
import fpml.confirmation.CommodityUSCoalProductModel;
import fpml.confirmation.CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder;
import fpml.confirmation.CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilderImpl;
import fpml.confirmation.CommodityUSCoalProductModel.CommodityUSCoalProductModelImpl;
import fpml.confirmation.meta.CommodityUSCoalProductModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items specific to the definition of a US Coal Product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityUSCoalProductModel", builder=CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityUSCoalProductModel extends RosettaModelObject {

	CommodityUSCoalProductModelMeta metaData = new CommodityUSCoalProductModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Quality Adjustment formula to be used where the Actual Shipment BTU/Lb value differs from the Standard BTU/Lb value.
	 */
	CoalQualityAdjustments getBtuQualityAdjustment();
	/**
	 * The Quality Adjustment formula to be used where the Actual Shipment SO2/MMBTU value differs from the Standard SO2/MMBTU value.
	 */
	CoalQualityAdjustments getSo2QualityAdjustment();

	/*********************** Build Methods  ***********************/
	CommodityUSCoalProductModel build();
	
	CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder toBuilder();
	
	static CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder builder() {
		return new CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityUSCoalProductModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityUSCoalProductModel> getType() {
		return CommodityUSCoalProductModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("btuQualityAdjustment"), processor, CoalQualityAdjustments.class, getBtuQualityAdjustment());
		processRosetta(path.newSubPath("so2QualityAdjustment"), processor, CoalQualityAdjustments.class, getSo2QualityAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityUSCoalProductModelBuilder extends CommodityUSCoalProductModel, RosettaModelObjectBuilder {
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateBtuQualityAdjustment();
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getBtuQualityAdjustment();
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateSo2QualityAdjustment();
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getSo2QualityAdjustment();
		CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder setBtuQualityAdjustment(CoalQualityAdjustments btuQualityAdjustment);
		CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder setSo2QualityAdjustment(CoalQualityAdjustments so2QualityAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("btuQualityAdjustment"), processor, CoalQualityAdjustments.CoalQualityAdjustmentsBuilder.class, getBtuQualityAdjustment());
			processRosetta(path.newSubPath("so2QualityAdjustment"), processor, CoalQualityAdjustments.CoalQualityAdjustmentsBuilder.class, getSo2QualityAdjustment());
		}
		

		CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityUSCoalProductModel  ***********************/
	class CommodityUSCoalProductModelImpl implements CommodityUSCoalProductModel {
		private final CoalQualityAdjustments btuQualityAdjustment;
		private final CoalQualityAdjustments so2QualityAdjustment;
		
		protected CommodityUSCoalProductModelImpl(CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder builder) {
			this.btuQualityAdjustment = ofNullable(builder.getBtuQualityAdjustment()).map(f->f.build()).orElse(null);
			this.so2QualityAdjustment = ofNullable(builder.getSo2QualityAdjustment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("btuQualityAdjustment")
		public CoalQualityAdjustments getBtuQualityAdjustment() {
			return btuQualityAdjustment;
		}
		
		@Override
		@RosettaAttribute("so2QualityAdjustment")
		public CoalQualityAdjustments getSo2QualityAdjustment() {
			return so2QualityAdjustment;
		}
		
		@Override
		public CommodityUSCoalProductModel build() {
			return this;
		}
		
		@Override
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder toBuilder() {
			CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder builder) {
			ofNullable(getBtuQualityAdjustment()).ifPresent(builder::setBtuQualityAdjustment);
			ofNullable(getSo2QualityAdjustment()).ifPresent(builder::setSo2QualityAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUSCoalProductModel _that = getType().cast(o);
		
			if (!Objects.equals(btuQualityAdjustment, _that.getBtuQualityAdjustment())) return false;
			if (!Objects.equals(so2QualityAdjustment, _that.getSo2QualityAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (btuQualityAdjustment != null ? btuQualityAdjustment.hashCode() : 0);
			_result = 31 * _result + (so2QualityAdjustment != null ? so2QualityAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUSCoalProductModel {" +
				"btuQualityAdjustment=" + this.btuQualityAdjustment + ", " +
				"so2QualityAdjustment=" + this.so2QualityAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityUSCoalProductModel  ***********************/
	class CommodityUSCoalProductModelBuilderImpl implements CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder {
	
		protected CoalQualityAdjustments.CoalQualityAdjustmentsBuilder btuQualityAdjustment;
		protected CoalQualityAdjustments.CoalQualityAdjustmentsBuilder so2QualityAdjustment;
	
		public CommodityUSCoalProductModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("btuQualityAdjustment")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getBtuQualityAdjustment() {
			return btuQualityAdjustment;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateBtuQualityAdjustment() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder result;
			if (btuQualityAdjustment!=null) {
				result = btuQualityAdjustment;
			}
			else {
				result = btuQualityAdjustment = CoalQualityAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("so2QualityAdjustment")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getSo2QualityAdjustment() {
			return so2QualityAdjustment;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateSo2QualityAdjustment() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder result;
			if (so2QualityAdjustment!=null) {
				result = so2QualityAdjustment;
			}
			else {
				result = so2QualityAdjustment = CoalQualityAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("btuQualityAdjustment")
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder setBtuQualityAdjustment(CoalQualityAdjustments btuQualityAdjustment) {
			this.btuQualityAdjustment = btuQualityAdjustment==null?null:btuQualityAdjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("so2QualityAdjustment")
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder setSo2QualityAdjustment(CoalQualityAdjustments so2QualityAdjustment) {
			this.so2QualityAdjustment = so2QualityAdjustment==null?null:so2QualityAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public CommodityUSCoalProductModel build() {
			return new CommodityUSCoalProductModel.CommodityUSCoalProductModelImpl(this);
		}
		
		@Override
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder prune() {
			if (btuQualityAdjustment!=null && !btuQualityAdjustment.prune().hasData()) btuQualityAdjustment = null;
			if (so2QualityAdjustment!=null && !so2QualityAdjustment.prune().hasData()) so2QualityAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBtuQualityAdjustment()!=null && getBtuQualityAdjustment().hasData()) return true;
			if (getSo2QualityAdjustment()!=null && getSo2QualityAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder o = (CommodityUSCoalProductModel.CommodityUSCoalProductModelBuilder) other;
			
			merger.mergeRosetta(getBtuQualityAdjustment(), o.getBtuQualityAdjustment(), this::setBtuQualityAdjustment);
			merger.mergeRosetta(getSo2QualityAdjustment(), o.getSo2QualityAdjustment(), this::setSo2QualityAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUSCoalProductModel _that = getType().cast(o);
		
			if (!Objects.equals(btuQualityAdjustment, _that.getBtuQualityAdjustment())) return false;
			if (!Objects.equals(so2QualityAdjustment, _that.getSo2QualityAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (btuQualityAdjustment != null ? btuQualityAdjustment.hashCode() : 0);
			_result = 31 * _result + (so2QualityAdjustment != null ? so2QualityAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUSCoalProductModelBuilder {" +
				"btuQualityAdjustment=" + this.btuQualityAdjustment + ", " +
				"so2QualityAdjustment=" + this.so2QualityAdjustment +
			'}';
		}
	}
}
