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
import fpml.confirmation.AssociationToAssetId;
import fpml.confirmation.AssociationToAssetId.AssociationToAssetIdBuilder;
import fpml.confirmation.AssociationToAssetId.AssociationToAssetIdBuilderImpl;
import fpml.confirmation.AssociationToAssetId.AssociationToAssetIdImpl;
import fpml.confirmation.meta.AssociationToAssetIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines an association identifier based on a qualifying scheme.
 * @version ${project.version}
 */
@RosettaDataType(value="AssociationToAssetId", builder=AssociationToAssetId.AssociationToAssetIdBuilderImpl.class, version="${project.version}")
public interface AssociationToAssetId extends RosettaModelObject {

	AssociationToAssetIdMeta metaData = new AssociationToAssetIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAssociationToAssetIdScheme();

	/*********************** Build Methods  ***********************/
	AssociationToAssetId build();
	
	AssociationToAssetId.AssociationToAssetIdBuilder toBuilder();
	
	static AssociationToAssetId.AssociationToAssetIdBuilder builder() {
		return new AssociationToAssetId.AssociationToAssetIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssociationToAssetId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AssociationToAssetId> getType() {
		return AssociationToAssetId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("associationToAssetIdScheme"), String.class, getAssociationToAssetIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssociationToAssetIdBuilder extends AssociationToAssetId, RosettaModelObjectBuilder {
		AssociationToAssetId.AssociationToAssetIdBuilder setValue(String value);
		AssociationToAssetId.AssociationToAssetIdBuilder setAssociationToAssetIdScheme(String associationToAssetIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("associationToAssetIdScheme"), String.class, getAssociationToAssetIdScheme(), this);
		}
		

		AssociationToAssetId.AssociationToAssetIdBuilder prune();
	}

	/*********************** Immutable Implementation of AssociationToAssetId  ***********************/
	class AssociationToAssetIdImpl implements AssociationToAssetId {
		private final String value;
		private final String associationToAssetIdScheme;
		
		protected AssociationToAssetIdImpl(AssociationToAssetId.AssociationToAssetIdBuilder builder) {
			this.value = builder.getValue();
			this.associationToAssetIdScheme = builder.getAssociationToAssetIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("associationToAssetIdScheme")
		public String getAssociationToAssetIdScheme() {
			return associationToAssetIdScheme;
		}
		
		@Override
		public AssociationToAssetId build() {
			return this;
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder toBuilder() {
			AssociationToAssetId.AssociationToAssetIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssociationToAssetId.AssociationToAssetIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAssociationToAssetIdScheme()).ifPresent(builder::setAssociationToAssetIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(associationToAssetIdScheme, _that.getAssociationToAssetIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (associationToAssetIdScheme != null ? associationToAssetIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetId {" +
				"value=" + this.value + ", " +
				"associationToAssetIdScheme=" + this.associationToAssetIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AssociationToAssetId  ***********************/
	class AssociationToAssetIdBuilderImpl implements AssociationToAssetId.AssociationToAssetIdBuilder {
	
		protected String value;
		protected String associationToAssetIdScheme;
	
		public AssociationToAssetIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("associationToAssetIdScheme")
		public String getAssociationToAssetIdScheme() {
			return associationToAssetIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AssociationToAssetId.AssociationToAssetIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("associationToAssetIdScheme")
		public AssociationToAssetId.AssociationToAssetIdBuilder setAssociationToAssetIdScheme(String associationToAssetIdScheme) {
			this.associationToAssetIdScheme = associationToAssetIdScheme==null?null:associationToAssetIdScheme;
			return this;
		}
		
		@Override
		public AssociationToAssetId build() {
			return new AssociationToAssetId.AssociationToAssetIdImpl(this);
		}
		
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAssociationToAssetIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssociationToAssetId.AssociationToAssetIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssociationToAssetId.AssociationToAssetIdBuilder o = (AssociationToAssetId.AssociationToAssetIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAssociationToAssetIdScheme(), o.getAssociationToAssetIdScheme(), this::setAssociationToAssetIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssociationToAssetId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(associationToAssetIdScheme, _that.getAssociationToAssetIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (associationToAssetIdScheme != null ? associationToAssetIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssociationToAssetIdBuilder {" +
				"value=" + this.value + ", " +
				"associationToAssetIdScheme=" + this.associationToAssetIdScheme +
			'}';
		}
	}
}
