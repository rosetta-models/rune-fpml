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
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder;
import fpml.confirmation.CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl;
import fpml.confirmation.CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CalculationPeriodsScheduleReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pointer style reference to a calculation periods schedule defined elsewhere - note that this schedule consists of a parameterised schedule in a calculationPeriodsSchedule container.
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationPeriodsScheduleReference", builder=CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl.class, version="${project.version}")
public interface CalculationPeriodsScheduleReference extends Reference {

	CalculationPeriodsScheduleReferenceMeta metaData = new CalculationPeriodsScheduleReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CalculationPeriodsScheduleReference build();
	
	CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder();
	
	static CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder() {
		return new CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodsScheduleReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodsScheduleReference> getType() {
		return CalculationPeriodsScheduleReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodsScheduleReferenceBuilder extends CalculationPeriodsScheduleReference, Reference.ReferenceBuilder {
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodsScheduleReference  ***********************/
	class CalculationPeriodsScheduleReferenceImpl extends Reference.ReferenceImpl implements CalculationPeriodsScheduleReference {
		private final String href;
		
		protected CalculationPeriodsScheduleReferenceImpl(CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CalculationPeriodsScheduleReference build() {
			return this;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodsScheduleReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodsScheduleReference  ***********************/
	class CalculationPeriodsScheduleReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder {
	
		protected String href;
	
		public CalculationPeriodsScheduleReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CalculationPeriodsScheduleReference build() {
			return new CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceImpl(this);
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder o = (CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationPeriodsScheduleReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
