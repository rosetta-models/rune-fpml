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
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CommodityCoalCompositionModel;
import fpml.confirmation.CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder;
import fpml.confirmation.CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilderImpl;
import fpml.confirmation.CommodityCoalCompositionModel.CommodityCoalCompositionModelImpl;
import fpml.confirmation.meta.CommodityCoalCompositionModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items defining the chemical composition of the coal product.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityCoalCompositionModel", builder=CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilderImpl.class, version="${project.version}")
public interface CommodityCoalCompositionModel extends RosettaModelObject {

	CommodityCoalCompositionModelMeta metaData = new CommodityCoalCompositionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The moisture content of the coal product.
	 */
	CoalAttributePercentage getMoisture();
	/**
	 * The ash content of the coal product.
	 */
	CoalAttributePercentage getAsh();
	/**
	 * The sulfur/sulphur content of the coal product.
	 */
	CoalAttributePercentage getSulfur();
	/**
	 * The sulfur/sulphur dioxide content of the coal product.
	 */
	CoalAttributePercentage getSO2();
	/**
	 * The volatile content of the coal product.
	 */
	CoalAttributePercentage getVolatile();

	/*********************** Build Methods  ***********************/
	CommodityCoalCompositionModel build();
	
	CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder toBuilder();
	
	static CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder builder() {
		return new CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCoalCompositionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityCoalCompositionModel> getType() {
		return CommodityCoalCompositionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("moisture"), processor, CoalAttributePercentage.class, getMoisture());
		processRosetta(path.newSubPath("ash"), processor, CoalAttributePercentage.class, getAsh());
		processRosetta(path.newSubPath("sulfur"), processor, CoalAttributePercentage.class, getSulfur());
		processRosetta(path.newSubPath("sO2"), processor, CoalAttributePercentage.class, getSO2());
		processRosetta(path.newSubPath("volatile"), processor, CoalAttributePercentage.class, getVolatile());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCoalCompositionModelBuilder extends CommodityCoalCompositionModel, RosettaModelObjectBuilder {
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateMoisture();
		CoalAttributePercentage.CoalAttributePercentageBuilder getMoisture();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateAsh();
		CoalAttributePercentage.CoalAttributePercentageBuilder getAsh();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSulfur();
		CoalAttributePercentage.CoalAttributePercentageBuilder getSulfur();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSO2();
		CoalAttributePercentage.CoalAttributePercentageBuilder getSO2();
		CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateVolatile();
		CoalAttributePercentage.CoalAttributePercentageBuilder getVolatile();
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setMoisture(CoalAttributePercentage moisture);
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setAsh(CoalAttributePercentage ash);
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setSulfur(CoalAttributePercentage sulfur);
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setSO2(CoalAttributePercentage sO2);
		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setVolatile(CoalAttributePercentage _volatile);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("moisture"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getMoisture());
			processRosetta(path.newSubPath("ash"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getAsh());
			processRosetta(path.newSubPath("sulfur"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getSulfur());
			processRosetta(path.newSubPath("sO2"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getSO2());
			processRosetta(path.newSubPath("volatile"), processor, CoalAttributePercentage.CoalAttributePercentageBuilder.class, getVolatile());
		}
		

		CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCoalCompositionModel  ***********************/
	class CommodityCoalCompositionModelImpl implements CommodityCoalCompositionModel {
		private final CoalAttributePercentage moisture;
		private final CoalAttributePercentage ash;
		private final CoalAttributePercentage sulfur;
		private final CoalAttributePercentage sO2;
		private final CoalAttributePercentage _volatile;
		
		protected CommodityCoalCompositionModelImpl(CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder builder) {
			this.moisture = ofNullable(builder.getMoisture()).map(f->f.build()).orElse(null);
			this.ash = ofNullable(builder.getAsh()).map(f->f.build()).orElse(null);
			this.sulfur = ofNullable(builder.getSulfur()).map(f->f.build()).orElse(null);
			this.sO2 = ofNullable(builder.getSO2()).map(f->f.build()).orElse(null);
			this._volatile = ofNullable(builder.getVolatile()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("moisture")
		public CoalAttributePercentage getMoisture() {
			return moisture;
		}
		
		@Override
		@RosettaAttribute("ash")
		public CoalAttributePercentage getAsh() {
			return ash;
		}
		
		@Override
		@RosettaAttribute("sulfur")
		public CoalAttributePercentage getSulfur() {
			return sulfur;
		}
		
		@Override
		@RosettaAttribute("sO2")
		public CoalAttributePercentage getSO2() {
			return sO2;
		}
		
		@Override
		@RosettaAttribute("volatile")
		public CoalAttributePercentage getVolatile() {
			return _volatile;
		}
		
		@Override
		public CommodityCoalCompositionModel build() {
			return this;
		}
		
		@Override
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder toBuilder() {
			CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder builder) {
			ofNullable(getMoisture()).ifPresent(builder::setMoisture);
			ofNullable(getAsh()).ifPresent(builder::setAsh);
			ofNullable(getSulfur()).ifPresent(builder::setSulfur);
			ofNullable(getSO2()).ifPresent(builder::setSO2);
			ofNullable(getVolatile()).ifPresent(builder::setVolatile);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalCompositionModel _that = getType().cast(o);
		
			if (!Objects.equals(moisture, _that.getMoisture())) return false;
			if (!Objects.equals(ash, _that.getAsh())) return false;
			if (!Objects.equals(sulfur, _that.getSulfur())) return false;
			if (!Objects.equals(sO2, _that.getSO2())) return false;
			if (!Objects.equals(_volatile, _that.getVolatile())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (moisture != null ? moisture.hashCode() : 0);
			_result = 31 * _result + (ash != null ? ash.hashCode() : 0);
			_result = 31 * _result + (sulfur != null ? sulfur.hashCode() : 0);
			_result = 31 * _result + (sO2 != null ? sO2.hashCode() : 0);
			_result = 31 * _result + (_volatile != null ? _volatile.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalCompositionModel {" +
				"moisture=" + this.moisture + ", " +
				"ash=" + this.ash + ", " +
				"sulfur=" + this.sulfur + ", " +
				"sO2=" + this.sO2 + ", " +
				"volatile=" + this._volatile +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityCoalCompositionModel  ***********************/
	class CommodityCoalCompositionModelBuilderImpl implements CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder {
	
		protected CoalAttributePercentage.CoalAttributePercentageBuilder moisture;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder ash;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder sulfur;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder sO2;
		protected CoalAttributePercentage.CoalAttributePercentageBuilder _volatile;
	
		public CommodityCoalCompositionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("moisture")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getMoisture() {
			return moisture;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateMoisture() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (moisture!=null) {
				result = moisture;
			}
			else {
				result = moisture = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ash")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getAsh() {
			return ash;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateAsh() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (ash!=null) {
				result = ash;
			}
			else {
				result = ash = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sulfur")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getSulfur() {
			return sulfur;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSulfur() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (sulfur!=null) {
				result = sulfur;
			}
			else {
				result = sulfur = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sO2")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getSO2() {
			return sO2;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateSO2() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (sO2!=null) {
				result = sO2;
			}
			else {
				result = sO2 = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatile")
		public CoalAttributePercentage.CoalAttributePercentageBuilder getVolatile() {
			return _volatile;
		}
		
		@Override
		public CoalAttributePercentage.CoalAttributePercentageBuilder getOrCreateVolatile() {
			CoalAttributePercentage.CoalAttributePercentageBuilder result;
			if (_volatile!=null) {
				result = _volatile;
			}
			else {
				result = _volatile = CoalAttributePercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("moisture")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setMoisture(CoalAttributePercentage moisture) {
			this.moisture = moisture==null?null:moisture.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("ash")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setAsh(CoalAttributePercentage ash) {
			this.ash = ash==null?null:ash.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sulfur")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setSulfur(CoalAttributePercentage sulfur) {
			this.sulfur = sulfur==null?null:sulfur.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sO2")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setSO2(CoalAttributePercentage sO2) {
			this.sO2 = sO2==null?null:sO2.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatile")
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder setVolatile(CoalAttributePercentage _volatile) {
			this._volatile = _volatile==null?null:_volatile.toBuilder();
			return this;
		}
		
		@Override
		public CommodityCoalCompositionModel build() {
			return new CommodityCoalCompositionModel.CommodityCoalCompositionModelImpl(this);
		}
		
		@Override
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder prune() {
			if (moisture!=null && !moisture.prune().hasData()) moisture = null;
			if (ash!=null && !ash.prune().hasData()) ash = null;
			if (sulfur!=null && !sulfur.prune().hasData()) sulfur = null;
			if (sO2!=null && !sO2.prune().hasData()) sO2 = null;
			if (_volatile!=null && !_volatile.prune().hasData()) _volatile = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMoisture()!=null && getMoisture().hasData()) return true;
			if (getAsh()!=null && getAsh().hasData()) return true;
			if (getSulfur()!=null && getSulfur().hasData()) return true;
			if (getSO2()!=null && getSO2().hasData()) return true;
			if (getVolatile()!=null && getVolatile().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder o = (CommodityCoalCompositionModel.CommodityCoalCompositionModelBuilder) other;
			
			merger.mergeRosetta(getMoisture(), o.getMoisture(), this::setMoisture);
			merger.mergeRosetta(getAsh(), o.getAsh(), this::setAsh);
			merger.mergeRosetta(getSulfur(), o.getSulfur(), this::setSulfur);
			merger.mergeRosetta(getSO2(), o.getSO2(), this::setSO2);
			merger.mergeRosetta(getVolatile(), o.getVolatile(), this::setVolatile);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalCompositionModel _that = getType().cast(o);
		
			if (!Objects.equals(moisture, _that.getMoisture())) return false;
			if (!Objects.equals(ash, _that.getAsh())) return false;
			if (!Objects.equals(sulfur, _that.getSulfur())) return false;
			if (!Objects.equals(sO2, _that.getSO2())) return false;
			if (!Objects.equals(_volatile, _that.getVolatile())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (moisture != null ? moisture.hashCode() : 0);
			_result = 31 * _result + (ash != null ? ash.hashCode() : 0);
			_result = 31 * _result + (sulfur != null ? sulfur.hashCode() : 0);
			_result = 31 * _result + (sO2 != null ? sO2.hashCode() : 0);
			_result = 31 * _result + (_volatile != null ? _volatile.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalCompositionModelBuilder {" +
				"moisture=" + this.moisture + ", " +
				"ash=" + this.ash + ", " +
				"sulfur=" + this.sulfur + ", " +
				"sO2=" + this.sO2 + ", " +
				"volatile=" + this._volatile +
			'}';
		}
	}
}
