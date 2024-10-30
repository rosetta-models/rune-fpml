package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AdditionalData;
import fpml.confirmation.ProblemLocation;
import fpml.confirmation.Reason;
import fpml.confirmation.Reason.ReasonBuilder;
import fpml.confirmation.Reason.ReasonBuilderImpl;
import fpml.confirmation.Reason.ReasonImpl;
import fpml.confirmation.ReasonCode;
import fpml.confirmation.Validation;
import fpml.confirmation.meta.ReasonMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a content model for describing the nature and possible location of a error within a previous message.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Reason", builder=Reason.ReasonBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Reason extends RosettaModelObject {

	ReasonMeta metaData = new ReasonMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A machine interpretable error code.
	 */
	ReasonCode getReasonCode();
	/**
	 * A value indicating the location of the problem within the subject message.
	 */
	ProblemLocation getLocation();
	/**
	 * Plain English text describing the associated error condition
	 */
	String getDescription();
	/**
	 * A reference identifying a rule within a validation scheme
	 */
	Validation getValidationRuleId();
	/**
	 * Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of any one of the messages (within a CDATA section).
	 */
	List<? extends AdditionalData> getAdditionalData();

	/*********************** Build Methods  ***********************/
	Reason build();
	
	Reason.ReasonBuilder toBuilder();
	
	static Reason.ReasonBuilder builder() {
		return new Reason.ReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Reason> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Reason> getType() {
		return Reason.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("reasonCode"), processor, ReasonCode.class, getReasonCode());
		processRosetta(path.newSubPath("location"), processor, ProblemLocation.class, getLocation());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("validationRuleId"), processor, Validation.class, getValidationRuleId());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReasonBuilder extends Reason, RosettaModelObjectBuilder {
		ReasonCode.ReasonCodeBuilder getOrCreateReasonCode();
		ReasonCode.ReasonCodeBuilder getReasonCode();
		ProblemLocation.ProblemLocationBuilder getOrCreateLocation();
		ProblemLocation.ProblemLocationBuilder getLocation();
		Validation.ValidationBuilder getOrCreateValidationRuleId();
		Validation.ValidationBuilder getValidationRuleId();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData(int _index);
		List<? extends AdditionalData.AdditionalDataBuilder> getAdditionalData();
		Reason.ReasonBuilder setReasonCode(ReasonCode reasonCode);
		Reason.ReasonBuilder setLocation(ProblemLocation location);
		Reason.ReasonBuilder setDescription(String description);
		Reason.ReasonBuilder setValidationRuleId(Validation validationRuleId);
		Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData0);
		Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData1, int _idx);
		Reason.ReasonBuilder addAdditionalData(List<? extends AdditionalData> additionalData2);
		Reason.ReasonBuilder setAdditionalData(List<? extends AdditionalData> additionalData3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("reasonCode"), processor, ReasonCode.ReasonCodeBuilder.class, getReasonCode());
			processRosetta(path.newSubPath("location"), processor, ProblemLocation.ProblemLocationBuilder.class, getLocation());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("validationRuleId"), processor, Validation.ValidationBuilder.class, getValidationRuleId());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
		}
		

		Reason.ReasonBuilder prune();
	}

	/*********************** Immutable Implementation of Reason  ***********************/
	class ReasonImpl implements Reason {
		private final ReasonCode reasonCode;
		private final ProblemLocation location;
		private final String description;
		private final Validation validationRuleId;
		private final List<? extends AdditionalData> additionalData;
		
		protected ReasonImpl(Reason.ReasonBuilder builder) {
			this.reasonCode = ofNullable(builder.getReasonCode()).map(f->f.build()).orElse(null);
			this.location = ofNullable(builder.getLocation()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
			this.validationRuleId = ofNullable(builder.getValidationRuleId()).map(f->f.build()).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reasonCode")
		public ReasonCode getReasonCode() {
			return reasonCode;
		}
		
		@Override
		@RosettaAttribute("location")
		public ProblemLocation getLocation() {
			return location;
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("validationRuleId")
		public Validation getValidationRuleId() {
			return validationRuleId;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		public List<? extends AdditionalData> getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public Reason build() {
			return this;
		}
		
		@Override
		public Reason.ReasonBuilder toBuilder() {
			Reason.ReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reason.ReasonBuilder builder) {
			ofNullable(getReasonCode()).ifPresent(builder::setReasonCode);
			ofNullable(getLocation()).ifPresent(builder::setLocation);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getValidationRuleId()).ifPresent(builder::setValidationRuleId);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reason _that = getType().cast(o);
		
			if (!Objects.equals(reasonCode, _that.getReasonCode())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(validationRuleId, _that.getValidationRuleId())) return false;
			if (!ListEquals.listEquals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reasonCode != null ? reasonCode.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (validationRuleId != null ? validationRuleId.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Reason {" +
				"reasonCode=" + this.reasonCode + ", " +
				"location=" + this.location + ", " +
				"description=" + this.description + ", " +
				"validationRuleId=" + this.validationRuleId + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}

	/*********************** Builder Implementation of Reason  ***********************/
	class ReasonBuilderImpl implements Reason.ReasonBuilder {
	
		protected ReasonCode.ReasonCodeBuilder reasonCode;
		protected ProblemLocation.ProblemLocationBuilder location;
		protected String description;
		protected Validation.ValidationBuilder validationRuleId;
		protected List<AdditionalData.AdditionalDataBuilder> additionalData = new ArrayList<>();
	
		public ReasonBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("reasonCode")
		public ReasonCode.ReasonCodeBuilder getReasonCode() {
			return reasonCode;
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder getOrCreateReasonCode() {
			ReasonCode.ReasonCodeBuilder result;
			if (reasonCode!=null) {
				result = reasonCode;
			}
			else {
				result = reasonCode = ReasonCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("location")
		public ProblemLocation.ProblemLocationBuilder getLocation() {
			return location;
		}
		
		@Override
		public ProblemLocation.ProblemLocationBuilder getOrCreateLocation() {
			ProblemLocation.ProblemLocationBuilder result;
			if (location!=null) {
				result = location;
			}
			else {
				result = location = ProblemLocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("validationRuleId")
		public Validation.ValidationBuilder getValidationRuleId() {
			return validationRuleId;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidationRuleId() {
			Validation.ValidationBuilder result;
			if (validationRuleId!=null) {
				result = validationRuleId;
			}
			else {
				result = validationRuleId = Validation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		public List<? extends AdditionalData.AdditionalDataBuilder> getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData(int _index) {
		
			if (additionalData==null) {
				this.additionalData = new ArrayList<>();
			}
			AdditionalData.AdditionalDataBuilder result;
			return getIndex(additionalData, _index, () -> {
						AdditionalData.AdditionalDataBuilder newAdditionalData = AdditionalData.builder();
						return newAdditionalData;
					});
		}
		
		@Override
		@RosettaAttribute("reasonCode")
		public Reason.ReasonBuilder setReasonCode(ReasonCode reasonCode) {
			this.reasonCode = reasonCode==null?null:reasonCode.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("location")
		public Reason.ReasonBuilder setLocation(ProblemLocation location) {
			this.location = location==null?null:location.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("description")
		public Reason.ReasonBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("validationRuleId")
		public Reason.ReasonBuilder setValidationRuleId(Validation validationRuleId) {
			this.validationRuleId = validationRuleId==null?null:validationRuleId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalData")
		public Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData) {
			if (additionalData!=null) this.additionalData.add(additionalData.toBuilder());
			return this;
		}
		
		@Override
		public Reason.ReasonBuilder addAdditionalData(AdditionalData additionalData, int _idx) {
			getIndex(this.additionalData, _idx, () -> additionalData.toBuilder());
			return this;
		}
		@Override 
		public Reason.ReasonBuilder addAdditionalData(List<? extends AdditionalData> additionalDatas) {
			if (additionalDatas != null) {
				for (AdditionalData toAdd : additionalDatas) {
					this.additionalData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Reason.ReasonBuilder setAdditionalData(List<? extends AdditionalData> additionalDatas) {
			if (additionalDatas == null)  {
				this.additionalData = new ArrayList<>();
			}
			else {
				this.additionalData = additionalDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Reason build() {
			return new Reason.ReasonImpl(this);
		}
		
		@Override
		public Reason.ReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reason.ReasonBuilder prune() {
			if (reasonCode!=null && !reasonCode.prune().hasData()) reasonCode = null;
			if (location!=null && !location.prune().hasData()) location = null;
			if (validationRuleId!=null && !validationRuleId.prune().hasData()) validationRuleId = null;
			additionalData = additionalData.stream().filter(b->b!=null).<AdditionalData.AdditionalDataBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReasonCode()!=null && getReasonCode().hasData()) return true;
			if (getLocation()!=null && getLocation().hasData()) return true;
			if (getDescription()!=null) return true;
			if (getValidationRuleId()!=null && getValidationRuleId().hasData()) return true;
			if (getAdditionalData()!=null && getAdditionalData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reason.ReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Reason.ReasonBuilder o = (Reason.ReasonBuilder) other;
			
			merger.mergeRosetta(getReasonCode(), o.getReasonCode(), this::setReasonCode);
			merger.mergeRosetta(getLocation(), o.getLocation(), this::setLocation);
			merger.mergeRosetta(getValidationRuleId(), o.getValidationRuleId(), this::setValidationRuleId);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::getOrCreateAdditionalData);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Reason _that = getType().cast(o);
		
			if (!Objects.equals(reasonCode, _that.getReasonCode())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(validationRuleId, _that.getValidationRuleId())) return false;
			if (!ListEquals.listEquals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reasonCode != null ? reasonCode.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (validationRuleId != null ? validationRuleId.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonBuilder {" +
				"reasonCode=" + this.reasonCode + ", " +
				"location=" + this.location + ", " +
				"description=" + this.description + ", " +
				"validationRuleId=" + this.validationRuleId + ", " +
				"additionalData=" + this.additionalData +
			'}';
		}
	}
}
