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
import fpml.confirmation.ReferenceBankId;
import fpml.confirmation.ReferenceBankId.ReferenceBankIdBuilder;
import fpml.confirmation.ReferenceBankId.ReferenceBankIdBuilderImpl;
import fpml.confirmation.ReferenceBankId.ReferenceBankIdImpl;
import fpml.confirmation.meta.ReferenceBankIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReferenceBankId", builder=ReferenceBankId.ReferenceBankIdBuilderImpl.class, version="${project.version}")
public interface ReferenceBankId extends RosettaModelObject {

	ReferenceBankIdMeta metaData = new ReferenceBankIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReferenceBankIdScheme();

	/*********************** Build Methods  ***********************/
	ReferenceBankId build();
	
	ReferenceBankId.ReferenceBankIdBuilder toBuilder();
	
	static ReferenceBankId.ReferenceBankIdBuilder builder() {
		return new ReferenceBankId.ReferenceBankIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceBankId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReferenceBankId> getType() {
		return ReferenceBankId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("referenceBankIdScheme"), String.class, getReferenceBankIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceBankIdBuilder extends ReferenceBankId, RosettaModelObjectBuilder {
		ReferenceBankId.ReferenceBankIdBuilder setValue(String value);
		ReferenceBankId.ReferenceBankIdBuilder setReferenceBankIdScheme(String referenceBankIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("referenceBankIdScheme"), String.class, getReferenceBankIdScheme(), this);
		}
		

		ReferenceBankId.ReferenceBankIdBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceBankId  ***********************/
	class ReferenceBankIdImpl implements ReferenceBankId {
		private final String value;
		private final String referenceBankIdScheme;
		
		protected ReferenceBankIdImpl(ReferenceBankId.ReferenceBankIdBuilder builder) {
			this.value = builder.getValue();
			this.referenceBankIdScheme = builder.getReferenceBankIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("referenceBankIdScheme")
		public String getReferenceBankIdScheme() {
			return referenceBankIdScheme;
		}
		
		@Override
		public ReferenceBankId build() {
			return this;
		}
		
		@Override
		public ReferenceBankId.ReferenceBankIdBuilder toBuilder() {
			ReferenceBankId.ReferenceBankIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceBankId.ReferenceBankIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReferenceBankIdScheme()).ifPresent(builder::setReferenceBankIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBankId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(referenceBankIdScheme, _that.getReferenceBankIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (referenceBankIdScheme != null ? referenceBankIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBankId {" +
				"value=" + this.value + ", " +
				"referenceBankIdScheme=" + this.referenceBankIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceBankId  ***********************/
	class ReferenceBankIdBuilderImpl implements ReferenceBankId.ReferenceBankIdBuilder {
	
		protected String value;
		protected String referenceBankIdScheme;
	
		public ReferenceBankIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("referenceBankIdScheme")
		public String getReferenceBankIdScheme() {
			return referenceBankIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReferenceBankId.ReferenceBankIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("referenceBankIdScheme")
		public ReferenceBankId.ReferenceBankIdBuilder setReferenceBankIdScheme(String referenceBankIdScheme) {
			this.referenceBankIdScheme = referenceBankIdScheme==null?null:referenceBankIdScheme;
			return this;
		}
		
		@Override
		public ReferenceBankId build() {
			return new ReferenceBankId.ReferenceBankIdImpl(this);
		}
		
		@Override
		public ReferenceBankId.ReferenceBankIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBankId.ReferenceBankIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReferenceBankIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceBankId.ReferenceBankIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceBankId.ReferenceBankIdBuilder o = (ReferenceBankId.ReferenceBankIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReferenceBankIdScheme(), o.getReferenceBankIdScheme(), this::setReferenceBankIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceBankId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(referenceBankIdScheme, _that.getReferenceBankIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (referenceBankIdScheme != null ? referenceBankIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceBankIdBuilder {" +
				"value=" + this.value + ", " +
				"referenceBankIdScheme=" + this.referenceBankIdScheme +
			'}';
		}
	}
}
