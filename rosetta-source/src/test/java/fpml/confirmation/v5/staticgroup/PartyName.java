package fpml.confirmation.v5.staticgroup;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.v5.staticgroup.meta.PartyNameMeta;

import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for the legal name of an organization.
 * @version 0.0.0
 */
@RosettaDataType(value="PartyName", builder=PartyName.PartyNameBuilderImpl.class, version="0.0.0")
public interface PartyName extends RosettaModelObject {

	PartyNameMeta metaData = new PartyNameMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyNameScheme();

	/*********************** Build Methods  ***********************/
	PartyName build();
	
	PartyNameBuilder toBuilder();
	
	static PartyNameBuilder builder() {
		return new PartyNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyName> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyName> getType() {
		return PartyName.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyNameScheme"), String.class, getPartyNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyNameBuilder extends PartyName, RosettaModelObjectBuilder {
		PartyNameBuilder setValue(String value);
		PartyNameBuilder setPartyNameScheme(String partyNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyNameScheme"), String.class, getPartyNameScheme(), this);
		}
		

		PartyNameBuilder prune();
	}

	/*********************** Immutable Implementation of PartyName  ***********************/
	class PartyNameImpl implements PartyName {
		private final String value;
		private final String partyNameScheme;
		
		protected PartyNameImpl(PartyNameBuilder builder) {
			this.value = builder.getValue();
			this.partyNameScheme = builder.getPartyNameScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyNameScheme")
		public String getPartyNameScheme() {
			return partyNameScheme;
		}
		
		@Override
		public PartyName build() {
			return this;
		}
		
		@Override
		public PartyNameBuilder toBuilder() {
			PartyNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyNameScheme()).ifPresent(builder::setPartyNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyNameScheme, _that.getPartyNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyNameScheme != null ? partyNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyName {" +
				"value=" + this.value + ", " +
				"partyNameScheme=" + this.partyNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyName  ***********************/
	class PartyNameBuilderImpl implements PartyNameBuilder {
	
		protected String value;
		protected String partyNameScheme;
	
		public PartyNameBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyNameScheme")
		public String getPartyNameScheme() {
			return partyNameScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyNameBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyNameScheme")
		public PartyNameBuilder setPartyNameScheme(String partyNameScheme) {
			this.partyNameScheme = partyNameScheme==null?null:partyNameScheme;
			return this;
		}
		
		@Override
		public PartyName build() {
			return new PartyNameImpl(this);
		}
		
		@Override
		public PartyNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyNameBuilder o = (PartyNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyNameScheme(), o.getPartyNameScheme(), this::setPartyNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyNameScheme, _that.getPartyNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyNameScheme != null ? partyNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyNameBuilder {" +
				"value=" + this.value + ", " +
				"partyNameScheme=" + this.partyNameScheme +
			'}';
		}
	}
}
