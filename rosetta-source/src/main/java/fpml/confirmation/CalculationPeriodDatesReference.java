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
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder;
import fpml.confirmation.CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilderImpl;
import fpml.confirmation.CalculationPeriodDatesReference.CalculationPeriodDatesReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CalculationPeriodDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a calculation period dates component.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CalculationPeriodDatesReference", builder=CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CalculationPeriodDatesReference extends Reference {

	CalculationPeriodDatesReferenceMeta metaData = new CalculationPeriodDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CalculationPeriodDatesReference build();
	
	CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder toBuilder();
	
	static CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder builder() {
		return new CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodDatesReference> getType() {
		return CalculationPeriodDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodDatesReferenceBuilder extends CalculationPeriodDatesReference, Reference.ReferenceBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodDatesReference  ***********************/
	class CalculationPeriodDatesReferenceImpl extends Reference.ReferenceImpl implements CalculationPeriodDatesReference {
		private final String href;
		
		protected CalculationPeriodDatesReferenceImpl(CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CalculationPeriodDatesReference build() {
			return this;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder toBuilder() {
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodDatesReference _that = getType().cast(o);
		
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
			return "CalculationPeriodDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodDatesReference  ***********************/
	class CalculationPeriodDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder {
	
		protected String href;
	
		public CalculationPeriodDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CalculationPeriodDatesReference build() {
			return new CalculationPeriodDatesReference.CalculationPeriodDatesReferenceImpl(this);
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder prune() {
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
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder o = (CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodDatesReference _that = getType().cast(o);
		
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
			return "CalculationPeriodDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
