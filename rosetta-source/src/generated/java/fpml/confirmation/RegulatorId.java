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
import fpml.confirmation.RegulatorId;
import fpml.confirmation.RegulatorId.RegulatorIdBuilder;
import fpml.confirmation.RegulatorId.RegulatorIdBuilderImpl;
import fpml.confirmation.RegulatorId.RegulatorIdImpl;
import fpml.confirmation.meta.RegulatorIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An ID assigned by a regulator to an organization registered with it. (NOTE: should this just by represented by an alternate party ID?)
 * @version ${project.version}
 */
@RosettaDataType(value="RegulatorId", builder=RegulatorId.RegulatorIdBuilderImpl.class, version="${project.version}")
public interface RegulatorId extends RosettaModelObject {

	RegulatorIdMeta metaData = new RegulatorIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRegulatorIdScheme();

	/*********************** Build Methods  ***********************/
	RegulatorId build();
	
	RegulatorId.RegulatorIdBuilder toBuilder();
	
	static RegulatorId.RegulatorIdBuilder builder() {
		return new RegulatorId.RegulatorIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatorId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RegulatorId> getType() {
		return RegulatorId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("regulatorIdScheme"), String.class, getRegulatorIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatorIdBuilder extends RegulatorId, RosettaModelObjectBuilder {
		RegulatorId.RegulatorIdBuilder setValue(String value);
		RegulatorId.RegulatorIdBuilder setRegulatorIdScheme(String regulatorIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("regulatorIdScheme"), String.class, getRegulatorIdScheme(), this);
		}
		

		RegulatorId.RegulatorIdBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatorId  ***********************/
	class RegulatorIdImpl implements RegulatorId {
		private final String value;
		private final String regulatorIdScheme;
		
		protected RegulatorIdImpl(RegulatorId.RegulatorIdBuilder builder) {
			this.value = builder.getValue();
			this.regulatorIdScheme = builder.getRegulatorIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regulatorIdScheme")
		public String getRegulatorIdScheme() {
			return regulatorIdScheme;
		}
		
		@Override
		public RegulatorId build() {
			return this;
		}
		
		@Override
		public RegulatorId.RegulatorIdBuilder toBuilder() {
			RegulatorId.RegulatorIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatorId.RegulatorIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRegulatorIdScheme()).ifPresent(builder::setRegulatorIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regulatorIdScheme, _that.getRegulatorIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regulatorIdScheme != null ? regulatorIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorId {" +
				"value=" + this.value + ", " +
				"regulatorIdScheme=" + this.regulatorIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatorId  ***********************/
	class RegulatorIdBuilderImpl implements RegulatorId.RegulatorIdBuilder {
	
		protected String value;
		protected String regulatorIdScheme;
	
		public RegulatorIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regulatorIdScheme")
		public String getRegulatorIdScheme() {
			return regulatorIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RegulatorId.RegulatorIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("regulatorIdScheme")
		public RegulatorId.RegulatorIdBuilder setRegulatorIdScheme(String regulatorIdScheme) {
			this.regulatorIdScheme = regulatorIdScheme==null?null:regulatorIdScheme;
			return this;
		}
		
		@Override
		public RegulatorId build() {
			return new RegulatorId.RegulatorIdImpl(this);
		}
		
		@Override
		public RegulatorId.RegulatorIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorId.RegulatorIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRegulatorIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatorId.RegulatorIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatorId.RegulatorIdBuilder o = (RegulatorId.RegulatorIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRegulatorIdScheme(), o.getRegulatorIdScheme(), this::setRegulatorIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatorId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regulatorIdScheme, _that.getRegulatorIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regulatorIdScheme != null ? regulatorIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatorIdBuilder {" +
				"value=" + this.value + ", " +
				"regulatorIdScheme=" + this.regulatorIdScheme +
			'}';
		}
	}
}
