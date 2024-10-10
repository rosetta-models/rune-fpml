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
import fpml.confirmation.PerturbationType;
import fpml.confirmation.PerturbationType.PerturbationTypeBuilder;
import fpml.confirmation.PerturbationType.PerturbationTypeBuilderImpl;
import fpml.confirmation.PerturbationType.PerturbationTypeImpl;
import fpml.confirmation.meta.PerturbationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PerturbationType", builder=PerturbationType.PerturbationTypeBuilderImpl.class, version="${project.version}")
public interface PerturbationType extends RosettaModelObject {

	PerturbationTypeMeta metaData = new PerturbationTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPerturbationTypeScheme();

	/*********************** Build Methods  ***********************/
	PerturbationType build();
	
	PerturbationType.PerturbationTypeBuilder toBuilder();
	
	static PerturbationType.PerturbationTypeBuilder builder() {
		return new PerturbationType.PerturbationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PerturbationType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PerturbationType> getType() {
		return PerturbationType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("perturbationTypeScheme"), String.class, getPerturbationTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PerturbationTypeBuilder extends PerturbationType, RosettaModelObjectBuilder {
		PerturbationType.PerturbationTypeBuilder setValue(String value);
		PerturbationType.PerturbationTypeBuilder setPerturbationTypeScheme(String perturbationTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("perturbationTypeScheme"), String.class, getPerturbationTypeScheme(), this);
		}
		

		PerturbationType.PerturbationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PerturbationType  ***********************/
	class PerturbationTypeImpl implements PerturbationType {
		private final String value;
		private final String perturbationTypeScheme;
		
		protected PerturbationTypeImpl(PerturbationType.PerturbationTypeBuilder builder) {
			this.value = builder.getValue();
			this.perturbationTypeScheme = builder.getPerturbationTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("perturbationTypeScheme")
		public String getPerturbationTypeScheme() {
			return perturbationTypeScheme;
		}
		
		@Override
		public PerturbationType build() {
			return this;
		}
		
		@Override
		public PerturbationType.PerturbationTypeBuilder toBuilder() {
			PerturbationType.PerturbationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PerturbationType.PerturbationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPerturbationTypeScheme()).ifPresent(builder::setPerturbationTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PerturbationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(perturbationTypeScheme, _that.getPerturbationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (perturbationTypeScheme != null ? perturbationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PerturbationType {" +
				"value=" + this.value + ", " +
				"perturbationTypeScheme=" + this.perturbationTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PerturbationType  ***********************/
	class PerturbationTypeBuilderImpl implements PerturbationType.PerturbationTypeBuilder {
	
		protected String value;
		protected String perturbationTypeScheme;
	
		public PerturbationTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("perturbationTypeScheme")
		public String getPerturbationTypeScheme() {
			return perturbationTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public PerturbationType.PerturbationTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("perturbationTypeScheme")
		public PerturbationType.PerturbationTypeBuilder setPerturbationTypeScheme(String perturbationTypeScheme) {
			this.perturbationTypeScheme = perturbationTypeScheme==null?null:perturbationTypeScheme;
			return this;
		}
		
		@Override
		public PerturbationType build() {
			return new PerturbationType.PerturbationTypeImpl(this);
		}
		
		@Override
		public PerturbationType.PerturbationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PerturbationType.PerturbationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPerturbationTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PerturbationType.PerturbationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PerturbationType.PerturbationTypeBuilder o = (PerturbationType.PerturbationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPerturbationTypeScheme(), o.getPerturbationTypeScheme(), this::setPerturbationTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PerturbationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(perturbationTypeScheme, _that.getPerturbationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (perturbationTypeScheme != null ? perturbationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PerturbationTypeBuilder {" +
				"value=" + this.value + ", " +
				"perturbationTypeScheme=" + this.perturbationTypeScheme +
			'}';
		}
	}
}
