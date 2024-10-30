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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityAsianModel;
import fpml.confirmation.CommodityDigital;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilderImpl;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelImpl;
import fpml.confirmation.meta.CommodityDigitalOptionFeaturesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes features of the digital option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityDigitalOptionFeaturesModel", builder=CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityDigitalOptionFeaturesModel extends RosettaModelObject {

	CommodityDigitalOptionFeaturesModelMeta metaData = new CommodityDigitalOptionFeaturesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The effective date of the Commodity Option Transaction. Note that the Termination/Expiration Date should be specified in expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type, as applicable.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of the Commodity Option Transaction. In some confirmations this will be indicated as the second date in &quot;Option Term&quot; or &quot;Term&quot;. Note: If provided, terminationDate should not be before specified expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	CommodityAsianModel getCommodityAsianModel();
	/**
	 * The barrier and cash payout features of the digital option.
	 */
	CommodityDigital getDigital();

	/*********************** Build Methods  ***********************/
	CommodityDigitalOptionFeaturesModel build();
	
	CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder toBuilder();
	
	static CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder builder() {
		return new CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigitalOptionFeaturesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDigitalOptionFeaturesModel> getType() {
		return CommodityDigitalOptionFeaturesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("commodityAsianModel"), processor, CommodityAsianModel.class, getCommodityAsianModel());
		processRosetta(path.newSubPath("digital"), processor, CommodityDigital.class, getDigital());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalOptionFeaturesModelBuilder extends CommodityDigitalOptionFeaturesModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		CommodityAsianModel.CommodityAsianModelBuilder getOrCreateCommodityAsianModel();
		CommodityAsianModel.CommodityAsianModelBuilder getCommodityAsianModel();
		CommodityDigital.CommodityDigitalBuilder getOrCreateDigital();
		CommodityDigital.CommodityDigitalBuilder getDigital();
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setCommodityAsianModel(CommodityAsianModel commodityAsianModel);
		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setDigital(CommodityDigital digital);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("commodityAsianModel"), processor, CommodityAsianModel.CommodityAsianModelBuilder.class, getCommodityAsianModel());
			processRosetta(path.newSubPath("digital"), processor, CommodityDigital.CommodityDigitalBuilder.class, getDigital());
		}
		

		CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigitalOptionFeaturesModel  ***********************/
	class CommodityDigitalOptionFeaturesModelImpl implements CommodityDigitalOptionFeaturesModel {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityAsianModel commodityAsianModel;
		private final CommodityDigital digital;
		
		protected CommodityDigitalOptionFeaturesModelImpl(CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.commodityAsianModel = ofNullable(builder.getCommodityAsianModel()).map(f->f.build()).orElse(null);
			this.digital = ofNullable(builder.getDigital()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("commodityAsianModel")
		public CommodityAsianModel getCommodityAsianModel() {
			return commodityAsianModel;
		}
		
		@Override
		@RosettaAttribute("digital")
		public CommodityDigital getDigital() {
			return digital;
		}
		
		@Override
		public CommodityDigitalOptionFeaturesModel build() {
			return this;
		}
		
		@Override
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder toBuilder() {
			CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCommodityAsianModel()).ifPresent(builder::setCommodityAsianModel);
			ofNullable(getDigital()).ifPresent(builder::setDigital);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(commodityAsianModel, _that.getCommodityAsianModel())) return false;
			if (!Objects.equals(digital, _that.getDigital())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (commodityAsianModel != null ? commodityAsianModel.hashCode() : 0);
			_result = 31 * _result + (digital != null ? digital.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionFeaturesModel {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"commodityAsianModel=" + this.commodityAsianModel + ", " +
				"digital=" + this.digital +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDigitalOptionFeaturesModel  ***********************/
	class CommodityDigitalOptionFeaturesModelBuilderImpl implements CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityAsianModel.CommodityAsianModelBuilder commodityAsianModel;
		protected CommodityDigital.CommodityDigitalBuilder digital;
	
		public CommodityDigitalOptionFeaturesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
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
		@RosettaAttribute("digital")
		public CommodityDigital.CommodityDigitalBuilder getDigital() {
			return digital;
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder getOrCreateDigital() {
			CommodityDigital.CommodityDigitalBuilder result;
			if (digital!=null) {
				result = digital;
			}
			else {
				result = digital = CommodityDigital.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityAsianModel")
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setCommodityAsianModel(CommodityAsianModel commodityAsianModel) {
			this.commodityAsianModel = commodityAsianModel==null?null:commodityAsianModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("digital")
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder setDigital(CommodityDigital digital) {
			this.digital = digital==null?null:digital.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDigitalOptionFeaturesModel build() {
			return new CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelImpl(this);
		}
		
		@Override
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (commodityAsianModel!=null && !commodityAsianModel.prune().hasData()) commodityAsianModel = null;
			if (digital!=null && !digital.prune().hasData()) digital = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCommodityAsianModel()!=null && getCommodityAsianModel().hasData()) return true;
			if (getDigital()!=null && getDigital().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder o = (CommodityDigitalOptionFeaturesModel.CommodityDigitalOptionFeaturesModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCommodityAsianModel(), o.getCommodityAsianModel(), this::setCommodityAsianModel);
			merger.mergeRosetta(getDigital(), o.getDigital(), this::setDigital);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(commodityAsianModel, _that.getCommodityAsianModel())) return false;
			if (!Objects.equals(digital, _that.getDigital())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (commodityAsianModel != null ? commodityAsianModel.hashCode() : 0);
			_result = 31 * _result + (digital != null ? digital.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionFeaturesModelBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"commodityAsianModel=" + this.commodityAsianModel + ", " +
				"digital=" + this.digital +
			'}';
		}
	}
}
