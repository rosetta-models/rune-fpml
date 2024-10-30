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
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingInputDatesModel.PricingInputDatesModelBuilder;
import fpml.confirmation.PricingInputDatesModel.PricingInputDatesModelBuilderImpl;
import fpml.confirmation.PricingInputDatesModel.PricingInputDatesModelImpl;
import fpml.confirmation.meta.PricingInputDatesModelMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The dates that might be relevant for a pricing input, e.g. what valuation date it applies to, when it was built, when the data comes from, etc..
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PricingInputDatesModel", builder=PricingInputDatesModel.PricingInputDatesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PricingInputDatesModel extends RosettaModelObject {

	PricingInputDatesModelMeta metaData = new PricingInputDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The base date for which the structure applies, i.e. the curve date. Normally this will align with the valuation date.
	 */
	IdentifiedDate getBaseDate();
	/**
	 * The spot settlement date for which the structure applies, normally 0-2 days after the base date. The difference between the baseDate and the spotDate is termed the settlement lag, and is sometimes called &quot;days to spot&quot;.
	 */
	IdentifiedDate getSpotDate();
	/**
	 * The date from which the input data used to construct the pricing input was obtained. Often the same as the baseDate, but sometimes the pricing input may be &quot;rolled forward&quot;, in which input data from one date is used to generate a curve for a later date.
	 */
	IdentifiedDate getInputDataDate();
	/**
	 * The last date for which data is supplied in this pricing input.
	 */
	IdentifiedDate getEndDate();
	/**
	 * The date and time when the pricing input was generated.
	 */
	ZonedDateTime getBuildDateTime();

	/*********************** Build Methods  ***********************/
	PricingInputDatesModel build();
	
	PricingInputDatesModel.PricingInputDatesModelBuilder toBuilder();
	
	static PricingInputDatesModel.PricingInputDatesModelBuilder builder() {
		return new PricingInputDatesModel.PricingInputDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingInputDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PricingInputDatesModel> getType() {
		return PricingInputDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.class, getBaseDate());
		processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.class, getSpotDate());
		processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.class, getInputDataDate());
		processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.class, getEndDate());
		processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingInputDatesModelBuilder extends PricingInputDatesModel, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateBaseDate();
		IdentifiedDate.IdentifiedDateBuilder getBaseDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateSpotDate();
		IdentifiedDate.IdentifiedDateBuilder getSpotDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateInputDataDate();
		IdentifiedDate.IdentifiedDateBuilder getInputDataDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEndDate();
		IdentifiedDate.IdentifiedDateBuilder getEndDate();
		PricingInputDatesModel.PricingInputDatesModelBuilder setBaseDate(IdentifiedDate baseDate);
		PricingInputDatesModel.PricingInputDatesModelBuilder setSpotDate(IdentifiedDate spotDate);
		PricingInputDatesModel.PricingInputDatesModelBuilder setInputDataDate(IdentifiedDate inputDataDate);
		PricingInputDatesModel.PricingInputDatesModelBuilder setEndDate(IdentifiedDate endDate);
		PricingInputDatesModel.PricingInputDatesModelBuilder setBuildDateTime(ZonedDateTime buildDateTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getBaseDate());
			processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSpotDate());
			processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getInputDataDate());
			processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEndDate());
			processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
		}
		

		PricingInputDatesModel.PricingInputDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of PricingInputDatesModel  ***********************/
	class PricingInputDatesModelImpl implements PricingInputDatesModel {
		private final IdentifiedDate baseDate;
		private final IdentifiedDate spotDate;
		private final IdentifiedDate inputDataDate;
		private final IdentifiedDate endDate;
		private final ZonedDateTime buildDateTime;
		
		protected PricingInputDatesModelImpl(PricingInputDatesModel.PricingInputDatesModelBuilder builder) {
			this.baseDate = ofNullable(builder.getBaseDate()).map(f->f.build()).orElse(null);
			this.spotDate = ofNullable(builder.getSpotDate()).map(f->f.build()).orElse(null);
			this.inputDataDate = ofNullable(builder.getInputDataDate()).map(f->f.build()).orElse(null);
			this.endDate = ofNullable(builder.getEndDate()).map(f->f.build()).orElse(null);
			this.buildDateTime = builder.getBuildDateTime();
		}
		
		@Override
		@RosettaAttribute("baseDate")
		public IdentifiedDate getBaseDate() {
			return baseDate;
		}
		
		@Override
		@RosettaAttribute("spotDate")
		public IdentifiedDate getSpotDate() {
			return spotDate;
		}
		
		@Override
		@RosettaAttribute("inputDataDate")
		public IdentifiedDate getInputDataDate() {
			return inputDataDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public IdentifiedDate getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("buildDateTime")
		public ZonedDateTime getBuildDateTime() {
			return buildDateTime;
		}
		
		@Override
		public PricingInputDatesModel build() {
			return this;
		}
		
		@Override
		public PricingInputDatesModel.PricingInputDatesModelBuilder toBuilder() {
			PricingInputDatesModel.PricingInputDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingInputDatesModel.PricingInputDatesModelBuilder builder) {
			ofNullable(getBaseDate()).ifPresent(builder::setBaseDate);
			ofNullable(getSpotDate()).ifPresent(builder::setSpotDate);
			ofNullable(getInputDataDate()).ifPresent(builder::setInputDataDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getBuildDateTime()).ifPresent(builder::setBuildDateTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(baseDate, _that.getBaseDate())) return false;
			if (!Objects.equals(spotDate, _that.getSpotDate())) return false;
			if (!Objects.equals(inputDataDate, _that.getInputDataDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(buildDateTime, _that.getBuildDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseDate != null ? baseDate.hashCode() : 0);
			_result = 31 * _result + (spotDate != null ? spotDate.hashCode() : 0);
			_result = 31 * _result + (inputDataDate != null ? inputDataDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (buildDateTime != null ? buildDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputDatesModel {" +
				"baseDate=" + this.baseDate + ", " +
				"spotDate=" + this.spotDate + ", " +
				"inputDataDate=" + this.inputDataDate + ", " +
				"endDate=" + this.endDate + ", " +
				"buildDateTime=" + this.buildDateTime +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingInputDatesModel  ***********************/
	class PricingInputDatesModelBuilderImpl implements PricingInputDatesModel.PricingInputDatesModelBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder baseDate;
		protected IdentifiedDate.IdentifiedDateBuilder spotDate;
		protected IdentifiedDate.IdentifiedDateBuilder inputDataDate;
		protected IdentifiedDate.IdentifiedDateBuilder endDate;
		protected ZonedDateTime buildDateTime;
	
		public PricingInputDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("baseDate")
		public IdentifiedDate.IdentifiedDateBuilder getBaseDate() {
			return baseDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateBaseDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (baseDate!=null) {
				result = baseDate;
			}
			else {
				result = baseDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotDate")
		public IdentifiedDate.IdentifiedDateBuilder getSpotDate() {
			return spotDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateSpotDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (spotDate!=null) {
				result = spotDate;
			}
			else {
				result = spotDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inputDataDate")
		public IdentifiedDate.IdentifiedDateBuilder getInputDataDate() {
			return inputDataDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateInputDataDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (inputDataDate!=null) {
				result = inputDataDate;
			}
			else {
				result = inputDataDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public IdentifiedDate.IdentifiedDateBuilder getEndDate() {
			return endDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEndDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (endDate!=null) {
				result = endDate;
			}
			else {
				result = endDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buildDateTime")
		public ZonedDateTime getBuildDateTime() {
			return buildDateTime;
		}
		
		@Override
		@RosettaAttribute("baseDate")
		public PricingInputDatesModel.PricingInputDatesModelBuilder setBaseDate(IdentifiedDate baseDate) {
			this.baseDate = baseDate==null?null:baseDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spotDate")
		public PricingInputDatesModel.PricingInputDatesModelBuilder setSpotDate(IdentifiedDate spotDate) {
			this.spotDate = spotDate==null?null:spotDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("inputDataDate")
		public PricingInputDatesModel.PricingInputDatesModelBuilder setInputDataDate(IdentifiedDate inputDataDate) {
			this.inputDataDate = inputDataDate==null?null:inputDataDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public PricingInputDatesModel.PricingInputDatesModelBuilder setEndDate(IdentifiedDate endDate) {
			this.endDate = endDate==null?null:endDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("buildDateTime")
		public PricingInputDatesModel.PricingInputDatesModelBuilder setBuildDateTime(ZonedDateTime buildDateTime) {
			this.buildDateTime = buildDateTime==null?null:buildDateTime;
			return this;
		}
		
		@Override
		public PricingInputDatesModel build() {
			return new PricingInputDatesModel.PricingInputDatesModelImpl(this);
		}
		
		@Override
		public PricingInputDatesModel.PricingInputDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputDatesModel.PricingInputDatesModelBuilder prune() {
			if (baseDate!=null && !baseDate.prune().hasData()) baseDate = null;
			if (spotDate!=null && !spotDate.prune().hasData()) spotDate = null;
			if (inputDataDate!=null && !inputDataDate.prune().hasData()) inputDataDate = null;
			if (endDate!=null && !endDate.prune().hasData()) endDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseDate()!=null && getBaseDate().hasData()) return true;
			if (getSpotDate()!=null && getSpotDate().hasData()) return true;
			if (getInputDataDate()!=null && getInputDataDate().hasData()) return true;
			if (getEndDate()!=null && getEndDate().hasData()) return true;
			if (getBuildDateTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingInputDatesModel.PricingInputDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingInputDatesModel.PricingInputDatesModelBuilder o = (PricingInputDatesModel.PricingInputDatesModelBuilder) other;
			
			merger.mergeRosetta(getBaseDate(), o.getBaseDate(), this::setBaseDate);
			merger.mergeRosetta(getSpotDate(), o.getSpotDate(), this::setSpotDate);
			merger.mergeRosetta(getInputDataDate(), o.getInputDataDate(), this::setInputDataDate);
			merger.mergeRosetta(getEndDate(), o.getEndDate(), this::setEndDate);
			
			merger.mergeBasic(getBuildDateTime(), o.getBuildDateTime(), this::setBuildDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingInputDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(baseDate, _that.getBaseDate())) return false;
			if (!Objects.equals(spotDate, _that.getSpotDate())) return false;
			if (!Objects.equals(inputDataDate, _that.getInputDataDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(buildDateTime, _that.getBuildDateTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseDate != null ? baseDate.hashCode() : 0);
			_result = 31 * _result + (spotDate != null ? spotDate.hashCode() : 0);
			_result = 31 * _result + (inputDataDate != null ? inputDataDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (buildDateTime != null ? buildDateTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingInputDatesModelBuilder {" +
				"baseDate=" + this.baseDate + ", " +
				"spotDate=" + this.spotDate + ", " +
				"inputDataDate=" + this.inputDataDate + ", " +
				"endDate=" + this.endDate + ", " +
				"buildDateTime=" + this.buildDateTime +
			'}';
		}
	}
}
