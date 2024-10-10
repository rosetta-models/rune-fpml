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
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CommodityCoalPropertiesModel;
import fpml.confirmation.CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder;
import fpml.confirmation.CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilderImpl;
import fpml.confirmation.CommodityCoalPropertiesModel.CommodityCoalPropertiesModelImpl;
import fpml.confirmation.meta.CommodityCoalPropertiesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items defining the physical attributes of the coal product.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityCoalPropertiesModel", builder=CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilderImpl.class, version="${project.version}")
public interface CommodityCoalPropertiesModel extends RosettaModelObject {

	CommodityCoalPropertiesModelMeta metaData = new CommodityCoalPropertiesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of British Thermal Units per Pound of the coal product.
	 */
	CoalAttributeDecimal getBtUperLB();
	/**
	 * The smallest sieve opening that will result in less than 5% of a sample of the coal product remaining.
	 */
	CoalAttributeDecimal getTopSize();
	CoalAttributeDecimal getFinesPassingScreen();
	/**
	 * The Hardgrove Grindability Index value of the coal to be delivered.
	 */
	CoalAttributeDecimal getGrindability();
	/**
	 * The temperature at which the ash form of the coal product fuses completely in accordance with the ASTM International D1857 Standard Test Methodology.
	 */
	CoalAttributeDecimal getAshFusionTemperature();

	/*********************** Build Methods  ***********************/
	CommodityCoalPropertiesModel build();
	
	CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder toBuilder();
	
	static CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder builder() {
		return new CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCoalPropertiesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityCoalPropertiesModel> getType() {
		return CommodityCoalPropertiesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("btUperLB"), processor, CoalAttributeDecimal.class, getBtUperLB());
		processRosetta(path.newSubPath("topSize"), processor, CoalAttributeDecimal.class, getTopSize());
		processRosetta(path.newSubPath("finesPassingScreen"), processor, CoalAttributeDecimal.class, getFinesPassingScreen());
		processRosetta(path.newSubPath("grindability"), processor, CoalAttributeDecimal.class, getGrindability());
		processRosetta(path.newSubPath("ashFusionTemperature"), processor, CoalAttributeDecimal.class, getAshFusionTemperature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCoalPropertiesModelBuilder extends CommodityCoalPropertiesModel, RosettaModelObjectBuilder {
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateBtUperLB();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getBtUperLB();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateTopSize();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getTopSize();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFinesPassingScreen();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getFinesPassingScreen();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateGrindability();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getGrindability();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateAshFusionTemperature();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getAshFusionTemperature();
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setBtUperLB(CoalAttributeDecimal btUperLB);
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setTopSize(CoalAttributeDecimal topSize);
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setFinesPassingScreen(CoalAttributeDecimal finesPassingScreen);
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setGrindability(CoalAttributeDecimal grindability);
		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setAshFusionTemperature(CoalAttributeDecimal ashFusionTemperature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("btUperLB"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getBtUperLB());
			processRosetta(path.newSubPath("topSize"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getTopSize());
			processRosetta(path.newSubPath("finesPassingScreen"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getFinesPassingScreen());
			processRosetta(path.newSubPath("grindability"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getGrindability());
			processRosetta(path.newSubPath("ashFusionTemperature"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getAshFusionTemperature());
		}
		

		CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCoalPropertiesModel  ***********************/
	class CommodityCoalPropertiesModelImpl implements CommodityCoalPropertiesModel {
		private final CoalAttributeDecimal btUperLB;
		private final CoalAttributeDecimal topSize;
		private final CoalAttributeDecimal finesPassingScreen;
		private final CoalAttributeDecimal grindability;
		private final CoalAttributeDecimal ashFusionTemperature;
		
		protected CommodityCoalPropertiesModelImpl(CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder builder) {
			this.btUperLB = ofNullable(builder.getBtUperLB()).map(f->f.build()).orElse(null);
			this.topSize = ofNullable(builder.getTopSize()).map(f->f.build()).orElse(null);
			this.finesPassingScreen = ofNullable(builder.getFinesPassingScreen()).map(f->f.build()).orElse(null);
			this.grindability = ofNullable(builder.getGrindability()).map(f->f.build()).orElse(null);
			this.ashFusionTemperature = ofNullable(builder.getAshFusionTemperature()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("btUperLB")
		public CoalAttributeDecimal getBtUperLB() {
			return btUperLB;
		}
		
		@Override
		@RosettaAttribute("topSize")
		public CoalAttributeDecimal getTopSize() {
			return topSize;
		}
		
		@Override
		@RosettaAttribute("finesPassingScreen")
		public CoalAttributeDecimal getFinesPassingScreen() {
			return finesPassingScreen;
		}
		
		@Override
		@RosettaAttribute("grindability")
		public CoalAttributeDecimal getGrindability() {
			return grindability;
		}
		
		@Override
		@RosettaAttribute("ashFusionTemperature")
		public CoalAttributeDecimal getAshFusionTemperature() {
			return ashFusionTemperature;
		}
		
		@Override
		public CommodityCoalPropertiesModel build() {
			return this;
		}
		
		@Override
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder toBuilder() {
			CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder builder) {
			ofNullable(getBtUperLB()).ifPresent(builder::setBtUperLB);
			ofNullable(getTopSize()).ifPresent(builder::setTopSize);
			ofNullable(getFinesPassingScreen()).ifPresent(builder::setFinesPassingScreen);
			ofNullable(getGrindability()).ifPresent(builder::setGrindability);
			ofNullable(getAshFusionTemperature()).ifPresent(builder::setAshFusionTemperature);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalPropertiesModel _that = getType().cast(o);
		
			if (!Objects.equals(btUperLB, _that.getBtUperLB())) return false;
			if (!Objects.equals(topSize, _that.getTopSize())) return false;
			if (!Objects.equals(finesPassingScreen, _that.getFinesPassingScreen())) return false;
			if (!Objects.equals(grindability, _that.getGrindability())) return false;
			if (!Objects.equals(ashFusionTemperature, _that.getAshFusionTemperature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (btUperLB != null ? btUperLB.hashCode() : 0);
			_result = 31 * _result + (topSize != null ? topSize.hashCode() : 0);
			_result = 31 * _result + (finesPassingScreen != null ? finesPassingScreen.hashCode() : 0);
			_result = 31 * _result + (grindability != null ? grindability.hashCode() : 0);
			_result = 31 * _result + (ashFusionTemperature != null ? ashFusionTemperature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalPropertiesModel {" +
				"btUperLB=" + this.btUperLB + ", " +
				"topSize=" + this.topSize + ", " +
				"finesPassingScreen=" + this.finesPassingScreen + ", " +
				"grindability=" + this.grindability + ", " +
				"ashFusionTemperature=" + this.ashFusionTemperature +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityCoalPropertiesModel  ***********************/
	class CommodityCoalPropertiesModelBuilderImpl implements CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder {
	
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder btUperLB;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder topSize;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder finesPassingScreen;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder grindability;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder ashFusionTemperature;
	
		public CommodityCoalPropertiesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("btUperLB")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getBtUperLB() {
			return btUperLB;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateBtUperLB() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (btUperLB!=null) {
				result = btUperLB;
			}
			else {
				result = btUperLB = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("topSize")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getTopSize() {
			return topSize;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateTopSize() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (topSize!=null) {
				result = topSize;
			}
			else {
				result = topSize = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finesPassingScreen")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getFinesPassingScreen() {
			return finesPassingScreen;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFinesPassingScreen() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (finesPassingScreen!=null) {
				result = finesPassingScreen;
			}
			else {
				result = finesPassingScreen = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grindability")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getGrindability() {
			return grindability;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateGrindability() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (grindability!=null) {
				result = grindability;
			}
			else {
				result = grindability = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ashFusionTemperature")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getAshFusionTemperature() {
			return ashFusionTemperature;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateAshFusionTemperature() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (ashFusionTemperature!=null) {
				result = ashFusionTemperature;
			}
			else {
				result = ashFusionTemperature = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("btUperLB")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setBtUperLB(CoalAttributeDecimal btUperLB) {
			this.btUperLB = btUperLB==null?null:btUperLB.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("topSize")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setTopSize(CoalAttributeDecimal topSize) {
			this.topSize = topSize==null?null:topSize.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finesPassingScreen")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setFinesPassingScreen(CoalAttributeDecimal finesPassingScreen) {
			this.finesPassingScreen = finesPassingScreen==null?null:finesPassingScreen.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("grindability")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setGrindability(CoalAttributeDecimal grindability) {
			this.grindability = grindability==null?null:grindability.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("ashFusionTemperature")
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder setAshFusionTemperature(CoalAttributeDecimal ashFusionTemperature) {
			this.ashFusionTemperature = ashFusionTemperature==null?null:ashFusionTemperature.toBuilder();
			return this;
		}
		
		@Override
		public CommodityCoalPropertiesModel build() {
			return new CommodityCoalPropertiesModel.CommodityCoalPropertiesModelImpl(this);
		}
		
		@Override
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder prune() {
			if (btUperLB!=null && !btUperLB.prune().hasData()) btUperLB = null;
			if (topSize!=null && !topSize.prune().hasData()) topSize = null;
			if (finesPassingScreen!=null && !finesPassingScreen.prune().hasData()) finesPassingScreen = null;
			if (grindability!=null && !grindability.prune().hasData()) grindability = null;
			if (ashFusionTemperature!=null && !ashFusionTemperature.prune().hasData()) ashFusionTemperature = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBtUperLB()!=null && getBtUperLB().hasData()) return true;
			if (getTopSize()!=null && getTopSize().hasData()) return true;
			if (getFinesPassingScreen()!=null && getFinesPassingScreen().hasData()) return true;
			if (getGrindability()!=null && getGrindability().hasData()) return true;
			if (getAshFusionTemperature()!=null && getAshFusionTemperature().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder o = (CommodityCoalPropertiesModel.CommodityCoalPropertiesModelBuilder) other;
			
			merger.mergeRosetta(getBtUperLB(), o.getBtUperLB(), this::setBtUperLB);
			merger.mergeRosetta(getTopSize(), o.getTopSize(), this::setTopSize);
			merger.mergeRosetta(getFinesPassingScreen(), o.getFinesPassingScreen(), this::setFinesPassingScreen);
			merger.mergeRosetta(getGrindability(), o.getGrindability(), this::setGrindability);
			merger.mergeRosetta(getAshFusionTemperature(), o.getAshFusionTemperature(), this::setAshFusionTemperature);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalPropertiesModel _that = getType().cast(o);
		
			if (!Objects.equals(btUperLB, _that.getBtUperLB())) return false;
			if (!Objects.equals(topSize, _that.getTopSize())) return false;
			if (!Objects.equals(finesPassingScreen, _that.getFinesPassingScreen())) return false;
			if (!Objects.equals(grindability, _that.getGrindability())) return false;
			if (!Objects.equals(ashFusionTemperature, _that.getAshFusionTemperature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (btUperLB != null ? btUperLB.hashCode() : 0);
			_result = 31 * _result + (topSize != null ? topSize.hashCode() : 0);
			_result = 31 * _result + (finesPassingScreen != null ? finesPassingScreen.hashCode() : 0);
			_result = 31 * _result + (grindability != null ? grindability.hashCode() : 0);
			_result = 31 * _result + (ashFusionTemperature != null ? ashFusionTemperature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalPropertiesModelBuilder {" +
				"btUperLB=" + this.btUperLB + ", " +
				"topSize=" + this.topSize + ", " +
				"finesPassingScreen=" + this.finesPassingScreen + ", " +
				"grindability=" + this.grindability + ", " +
				"ashFusionTemperature=" + this.ashFusionTemperature +
			'}';
		}
	}
}
