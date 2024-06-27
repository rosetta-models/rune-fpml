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
import fpml.confirmation.v5.staticgroup.meta.PartyIdMeta;

import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for party identifiers.
 * @version 0.0.0
 */
@RosettaDataType(value="PartyId", builder=PartyId.PartyIdBuilderImpl.class, version="0.0.0")
public interface PartyId extends RosettaModelObject {

	PartyIdMeta metaData = new PartyIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPartyIdScheme();

	/*********************** Build Methods  ***********************/
	PartyId build();
	
	PartyIdBuilder toBuilder();
	
	static PartyIdBuilder builder() {
		return new PartyIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyId> getType() {
		return PartyId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("partyIdScheme"), String.class, getPartyIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyIdBuilder extends PartyId, RosettaModelObjectBuilder {
		PartyIdBuilder setValue(String value);
		PartyIdBuilder setPartyIdScheme(String partyIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("partyIdScheme"), String.class, getPartyIdScheme(), this);
		}
		

		PartyIdBuilder prune();
	}

	/*********************** Immutable Implementation of PartyId  ***********************/
	class PartyIdImpl implements PartyId {
		private final String value;
		private final String partyIdScheme;
		
		protected PartyIdImpl(PartyIdBuilder builder) {
			this.value = builder.getValue();
			this.partyIdScheme = builder.getPartyIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyIdScheme")
		public String getPartyIdScheme() {
			return partyIdScheme;
		}
		
		@Override
		public PartyId build() {
			return this;
		}
		
		@Override
		public PartyIdBuilder toBuilder() {
			PartyIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPartyIdScheme()).ifPresent(builder::setPartyIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyIdScheme, _that.getPartyIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyIdScheme != null ? partyIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyId {" +
				"value=" + this.value + ", " +
				"partyIdScheme=" + this.partyIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyId  ***********************/
	class PartyIdBuilderImpl implements PartyIdBuilder {
	
		protected String value;
		protected String partyIdScheme;
	
		public PartyIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("partyIdScheme")
		public String getPartyIdScheme() {
			return partyIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PartyIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("partyIdScheme")
		public PartyIdBuilder setPartyIdScheme(String partyIdScheme) {
			this.partyIdScheme = partyIdScheme==null?null:partyIdScheme;
			return this;
		}
		
		@Override
		public PartyId build() {
			return new PartyIdImpl(this);
		}
		
		@Override
		public PartyIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPartyIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyIdBuilder o = (PartyIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPartyIdScheme(), o.getPartyIdScheme(), this::setPartyIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(partyIdScheme, _that.getPartyIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (partyIdScheme != null ? partyIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyIdBuilder {" +
				"value=" + this.value + ", " +
				"partyIdScheme=" + this.partyIdScheme +
			'}';
		}
	}
}
