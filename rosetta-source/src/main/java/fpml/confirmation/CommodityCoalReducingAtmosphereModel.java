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
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilderImpl;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelImpl;
import fpml.confirmation.meta.CommodityCoalReducingAtmosphereModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Items defining the attributes of the coal product determined by ash fusion tests.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityCoalReducingAtmosphereModel", builder=CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityCoalReducingAtmosphereModel extends RosettaModelObject {

	CommodityCoalReducingAtmosphereModelMeta metaData = new CommodityCoalReducingAtmosphereModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The temperature at which an ash cone shows evidence of deformation.
	 */
	CoalAttributeDecimal getInitialDeformation();
	/**
	 * The temperature at which the height of an ash cone equals its width. (Softening temperature).
	 */
	CoalAttributeDecimal getSofteningHeightWidth();
	/**
	 * The temperature at which the height of an ash cone equals half its width. (Hemisphere temperature).
	 */
	CoalAttributeDecimal getSofteningHeightHalfWidth();
	/**
	 * The temperature at which the ash cone flattens.
	 */
	CoalAttributeDecimal getFluid();

	/*********************** Build Methods  ***********************/
	CommodityCoalReducingAtmosphereModel build();
	
	CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder toBuilder();
	
	static CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder builder() {
		return new CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCoalReducingAtmosphereModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityCoalReducingAtmosphereModel> getType() {
		return CommodityCoalReducingAtmosphereModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialDeformation"), processor, CoalAttributeDecimal.class, getInitialDeformation());
		processRosetta(path.newSubPath("softeningHeightWidth"), processor, CoalAttributeDecimal.class, getSofteningHeightWidth());
		processRosetta(path.newSubPath("softeningHeightHalfWidth"), processor, CoalAttributeDecimal.class, getSofteningHeightHalfWidth());
		processRosetta(path.newSubPath("fluid"), processor, CoalAttributeDecimal.class, getFluid());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCoalReducingAtmosphereModelBuilder extends CommodityCoalReducingAtmosphereModel, RosettaModelObjectBuilder {
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateInitialDeformation();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getInitialDeformation();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightHalfWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightHalfWidth();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFluid();
		CoalAttributeDecimal.CoalAttributeDecimalBuilder getFluid();
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setInitialDeformation(CoalAttributeDecimal initialDeformation);
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setSofteningHeightWidth(CoalAttributeDecimal softeningHeightWidth);
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setSofteningHeightHalfWidth(CoalAttributeDecimal softeningHeightHalfWidth);
		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setFluid(CoalAttributeDecimal fluid);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialDeformation"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getInitialDeformation());
			processRosetta(path.newSubPath("softeningHeightWidth"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getSofteningHeightWidth());
			processRosetta(path.newSubPath("softeningHeightHalfWidth"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getSofteningHeightHalfWidth());
			processRosetta(path.newSubPath("fluid"), processor, CoalAttributeDecimal.CoalAttributeDecimalBuilder.class, getFluid());
		}
		

		CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCoalReducingAtmosphereModel  ***********************/
	class CommodityCoalReducingAtmosphereModelImpl implements CommodityCoalReducingAtmosphereModel {
		private final CoalAttributeDecimal initialDeformation;
		private final CoalAttributeDecimal softeningHeightWidth;
		private final CoalAttributeDecimal softeningHeightHalfWidth;
		private final CoalAttributeDecimal fluid;
		
		protected CommodityCoalReducingAtmosphereModelImpl(CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder builder) {
			this.initialDeformation = ofNullable(builder.getInitialDeformation()).map(f->f.build()).orElse(null);
			this.softeningHeightWidth = ofNullable(builder.getSofteningHeightWidth()).map(f->f.build()).orElse(null);
			this.softeningHeightHalfWidth = ofNullable(builder.getSofteningHeightHalfWidth()).map(f->f.build()).orElse(null);
			this.fluid = ofNullable(builder.getFluid()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialDeformation")
		public CoalAttributeDecimal getInitialDeformation() {
			return initialDeformation;
		}
		
		@Override
		@RosettaAttribute("softeningHeightWidth")
		public CoalAttributeDecimal getSofteningHeightWidth() {
			return softeningHeightWidth;
		}
		
		@Override
		@RosettaAttribute("softeningHeightHalfWidth")
		public CoalAttributeDecimal getSofteningHeightHalfWidth() {
			return softeningHeightHalfWidth;
		}
		
		@Override
		@RosettaAttribute("fluid")
		public CoalAttributeDecimal getFluid() {
			return fluid;
		}
		
		@Override
		public CommodityCoalReducingAtmosphereModel build() {
			return this;
		}
		
		@Override
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder toBuilder() {
			CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder builder) {
			ofNullable(getInitialDeformation()).ifPresent(builder::setInitialDeformation);
			ofNullable(getSofteningHeightWidth()).ifPresent(builder::setSofteningHeightWidth);
			ofNullable(getSofteningHeightHalfWidth()).ifPresent(builder::setSofteningHeightHalfWidth);
			ofNullable(getFluid()).ifPresent(builder::setFluid);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalReducingAtmosphereModel _that = getType().cast(o);
		
			if (!Objects.equals(initialDeformation, _that.getInitialDeformation())) return false;
			if (!Objects.equals(softeningHeightWidth, _that.getSofteningHeightWidth())) return false;
			if (!Objects.equals(softeningHeightHalfWidth, _that.getSofteningHeightHalfWidth())) return false;
			if (!Objects.equals(fluid, _that.getFluid())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialDeformation != null ? initialDeformation.hashCode() : 0);
			_result = 31 * _result + (softeningHeightWidth != null ? softeningHeightWidth.hashCode() : 0);
			_result = 31 * _result + (softeningHeightHalfWidth != null ? softeningHeightHalfWidth.hashCode() : 0);
			_result = 31 * _result + (fluid != null ? fluid.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalReducingAtmosphereModel {" +
				"initialDeformation=" + this.initialDeformation + ", " +
				"softeningHeightWidth=" + this.softeningHeightWidth + ", " +
				"softeningHeightHalfWidth=" + this.softeningHeightHalfWidth + ", " +
				"fluid=" + this.fluid +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityCoalReducingAtmosphereModel  ***********************/
	class CommodityCoalReducingAtmosphereModelBuilderImpl implements CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder {
	
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder initialDeformation;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder softeningHeightWidth;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder softeningHeightHalfWidth;
		protected CoalAttributeDecimal.CoalAttributeDecimalBuilder fluid;
	
		public CommodityCoalReducingAtmosphereModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialDeformation")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getInitialDeformation() {
			return initialDeformation;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateInitialDeformation() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (initialDeformation!=null) {
				result = initialDeformation;
			}
			else {
				result = initialDeformation = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("softeningHeightWidth")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightWidth() {
			return softeningHeightWidth;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightWidth() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (softeningHeightWidth!=null) {
				result = softeningHeightWidth;
			}
			else {
				result = softeningHeightWidth = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("softeningHeightHalfWidth")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getSofteningHeightHalfWidth() {
			return softeningHeightHalfWidth;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateSofteningHeightHalfWidth() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (softeningHeightHalfWidth!=null) {
				result = softeningHeightHalfWidth;
			}
			else {
				result = softeningHeightHalfWidth = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fluid")
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getFluid() {
			return fluid;
		}
		
		@Override
		public CoalAttributeDecimal.CoalAttributeDecimalBuilder getOrCreateFluid() {
			CoalAttributeDecimal.CoalAttributeDecimalBuilder result;
			if (fluid!=null) {
				result = fluid;
			}
			else {
				result = fluid = CoalAttributeDecimal.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialDeformation")
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setInitialDeformation(CoalAttributeDecimal initialDeformation) {
			this.initialDeformation = initialDeformation==null?null:initialDeformation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("softeningHeightWidth")
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setSofteningHeightWidth(CoalAttributeDecimal softeningHeightWidth) {
			this.softeningHeightWidth = softeningHeightWidth==null?null:softeningHeightWidth.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("softeningHeightHalfWidth")
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setSofteningHeightHalfWidth(CoalAttributeDecimal softeningHeightHalfWidth) {
			this.softeningHeightHalfWidth = softeningHeightHalfWidth==null?null:softeningHeightHalfWidth.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fluid")
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder setFluid(CoalAttributeDecimal fluid) {
			this.fluid = fluid==null?null:fluid.toBuilder();
			return this;
		}
		
		@Override
		public CommodityCoalReducingAtmosphereModel build() {
			return new CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelImpl(this);
		}
		
		@Override
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder prune() {
			if (initialDeformation!=null && !initialDeformation.prune().hasData()) initialDeformation = null;
			if (softeningHeightWidth!=null && !softeningHeightWidth.prune().hasData()) softeningHeightWidth = null;
			if (softeningHeightHalfWidth!=null && !softeningHeightHalfWidth.prune().hasData()) softeningHeightHalfWidth = null;
			if (fluid!=null && !fluid.prune().hasData()) fluid = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialDeformation()!=null && getInitialDeformation().hasData()) return true;
			if (getSofteningHeightWidth()!=null && getSofteningHeightWidth().hasData()) return true;
			if (getSofteningHeightHalfWidth()!=null && getSofteningHeightHalfWidth().hasData()) return true;
			if (getFluid()!=null && getFluid().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder o = (CommodityCoalReducingAtmosphereModel.CommodityCoalReducingAtmosphereModelBuilder) other;
			
			merger.mergeRosetta(getInitialDeformation(), o.getInitialDeformation(), this::setInitialDeformation);
			merger.mergeRosetta(getSofteningHeightWidth(), o.getSofteningHeightWidth(), this::setSofteningHeightWidth);
			merger.mergeRosetta(getSofteningHeightHalfWidth(), o.getSofteningHeightHalfWidth(), this::setSofteningHeightHalfWidth);
			merger.mergeRosetta(getFluid(), o.getFluid(), this::setFluid);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityCoalReducingAtmosphereModel _that = getType().cast(o);
		
			if (!Objects.equals(initialDeformation, _that.getInitialDeformation())) return false;
			if (!Objects.equals(softeningHeightWidth, _that.getSofteningHeightWidth())) return false;
			if (!Objects.equals(softeningHeightHalfWidth, _that.getSofteningHeightHalfWidth())) return false;
			if (!Objects.equals(fluid, _that.getFluid())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialDeformation != null ? initialDeformation.hashCode() : 0);
			_result = 31 * _result + (softeningHeightWidth != null ? softeningHeightWidth.hashCode() : 0);
			_result = 31 * _result + (softeningHeightHalfWidth != null ? softeningHeightHalfWidth.hashCode() : 0);
			_result = 31 * _result + (fluid != null ? fluid.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCoalReducingAtmosphereModelBuilder {" +
				"initialDeformation=" + this.initialDeformation + ", " +
				"softeningHeightWidth=" + this.softeningHeightWidth + ", " +
				"softeningHeightHalfWidth=" + this.softeningHeightHalfWidth + ", " +
				"fluid=" + this.fluid +
			'}';
		}
	}
}
