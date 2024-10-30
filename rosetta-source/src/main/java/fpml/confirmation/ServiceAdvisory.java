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
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.ServiceAdvisory.ServiceAdvisoryBuilder;
import fpml.confirmation.ServiceAdvisory.ServiceAdvisoryBuilderImpl;
import fpml.confirmation.ServiceAdvisory.ServiceAdvisoryImpl;
import fpml.confirmation.ServiceAdvisoryCategory;
import fpml.confirmation.meta.ServiceAdvisoryMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a human-readable notification to the users of a service.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ServiceAdvisory", builder=ServiceAdvisory.ServiceAdvisoryBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ServiceAdvisory extends RosettaModelObject {

	ServiceAdvisoryMeta metaData = new ServiceAdvisoryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The category or type of the notification message, e.g. availability, product coverage, rules, etc.
	 */
	ServiceAdvisoryCategory getCategory();
	/**
	 * A human-readable notification.
	 */
	String getDescription();
	/**
	 * The time at which the information supplied by the advisory becomes effective. For example, if the advisory advises of a newly planned service outage, it will be the time the service outage begins.
	 */
	ZonedDateTime getEffectiveFrom();
	/**
	 * The time at which the information supplied by the advisory becomes no longer effective. For example, if the advisory advises of a newly planned service outage, it will be the time the service outage ends.
	 */
	ZonedDateTime getEffectiveTo();

	/*********************** Build Methods  ***********************/
	ServiceAdvisory build();
	
	ServiceAdvisory.ServiceAdvisoryBuilder toBuilder();
	
	static ServiceAdvisory.ServiceAdvisoryBuilder builder() {
		return new ServiceAdvisory.ServiceAdvisoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ServiceAdvisory> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ServiceAdvisory> getType() {
		return ServiceAdvisory.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("category"), processor, ServiceAdvisoryCategory.class, getCategory());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processor.processBasic(path.newSubPath("effectiveFrom"), ZonedDateTime.class, getEffectiveFrom(), this);
		processor.processBasic(path.newSubPath("effectiveTo"), ZonedDateTime.class, getEffectiveTo(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ServiceAdvisoryBuilder extends ServiceAdvisory, RosettaModelObjectBuilder {
		ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder getOrCreateCategory();
		ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder getCategory();
		ServiceAdvisory.ServiceAdvisoryBuilder setCategory(ServiceAdvisoryCategory category);
		ServiceAdvisory.ServiceAdvisoryBuilder setDescription(String description);
		ServiceAdvisory.ServiceAdvisoryBuilder setEffectiveFrom(ZonedDateTime effectiveFrom);
		ServiceAdvisory.ServiceAdvisoryBuilder setEffectiveTo(ZonedDateTime effectiveTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("category"), processor, ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder.class, getCategory());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processor.processBasic(path.newSubPath("effectiveFrom"), ZonedDateTime.class, getEffectiveFrom(), this);
			processor.processBasic(path.newSubPath("effectiveTo"), ZonedDateTime.class, getEffectiveTo(), this);
		}
		

		ServiceAdvisory.ServiceAdvisoryBuilder prune();
	}

	/*********************** Immutable Implementation of ServiceAdvisory  ***********************/
	class ServiceAdvisoryImpl implements ServiceAdvisory {
		private final ServiceAdvisoryCategory category;
		private final String description;
		private final ZonedDateTime effectiveFrom;
		private final ZonedDateTime effectiveTo;
		
		protected ServiceAdvisoryImpl(ServiceAdvisory.ServiceAdvisoryBuilder builder) {
			this.category = ofNullable(builder.getCategory()).map(f->f.build()).orElse(null);
			this.description = builder.getDescription();
			this.effectiveFrom = builder.getEffectiveFrom();
			this.effectiveTo = builder.getEffectiveTo();
		}
		
		@Override
		@RosettaAttribute("category")
		public ServiceAdvisoryCategory getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("effectiveFrom")
		public ZonedDateTime getEffectiveFrom() {
			return effectiveFrom;
		}
		
		@Override
		@RosettaAttribute("effectiveTo")
		public ZonedDateTime getEffectiveTo() {
			return effectiveTo;
		}
		
		@Override
		public ServiceAdvisory build() {
			return this;
		}
		
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder toBuilder() {
			ServiceAdvisory.ServiceAdvisoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ServiceAdvisory.ServiceAdvisoryBuilder builder) {
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getEffectiveFrom()).ifPresent(builder::setEffectiveFrom);
			ofNullable(getEffectiveTo()).ifPresent(builder::setEffectiveTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceAdvisory _that = getType().cast(o);
		
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(effectiveFrom, _that.getEffectiveFrom())) return false;
			if (!Objects.equals(effectiveTo, _that.getEffectiveTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (effectiveFrom != null ? effectiveFrom.hashCode() : 0);
			_result = 31 * _result + (effectiveTo != null ? effectiveTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceAdvisory {" +
				"category=" + this.category + ", " +
				"description=" + this.description + ", " +
				"effectiveFrom=" + this.effectiveFrom + ", " +
				"effectiveTo=" + this.effectiveTo +
			'}';
		}
	}

	/*********************** Builder Implementation of ServiceAdvisory  ***********************/
	class ServiceAdvisoryBuilderImpl implements ServiceAdvisory.ServiceAdvisoryBuilder {
	
		protected ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder category;
		protected String description;
		protected ZonedDateTime effectiveFrom;
		protected ZonedDateTime effectiveTo;
	
		public ServiceAdvisoryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("category")
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder getCategory() {
			return category;
		}
		
		@Override
		public ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder getOrCreateCategory() {
			ServiceAdvisoryCategory.ServiceAdvisoryCategoryBuilder result;
			if (category!=null) {
				result = category;
			}
			else {
				result = category = ServiceAdvisoryCategory.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("effectiveFrom")
		public ZonedDateTime getEffectiveFrom() {
			return effectiveFrom;
		}
		
		@Override
		@RosettaAttribute("effectiveTo")
		public ZonedDateTime getEffectiveTo() {
			return effectiveTo;
		}
		
		@Override
		@RosettaAttribute("category")
		public ServiceAdvisory.ServiceAdvisoryBuilder setCategory(ServiceAdvisoryCategory category) {
			this.category = category==null?null:category.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("description")
		public ServiceAdvisory.ServiceAdvisoryBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("effectiveFrom")
		public ServiceAdvisory.ServiceAdvisoryBuilder setEffectiveFrom(ZonedDateTime effectiveFrom) {
			this.effectiveFrom = effectiveFrom==null?null:effectiveFrom;
			return this;
		}
		@Override
		@RosettaAttribute("effectiveTo")
		public ServiceAdvisory.ServiceAdvisoryBuilder setEffectiveTo(ZonedDateTime effectiveTo) {
			this.effectiveTo = effectiveTo==null?null:effectiveTo;
			return this;
		}
		
		@Override
		public ServiceAdvisory build() {
			return new ServiceAdvisory.ServiceAdvisoryImpl(this);
		}
		
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder prune() {
			if (category!=null && !category.prune().hasData()) category = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCategory()!=null && getCategory().hasData()) return true;
			if (getDescription()!=null) return true;
			if (getEffectiveFrom()!=null) return true;
			if (getEffectiveTo()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ServiceAdvisory.ServiceAdvisoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ServiceAdvisory.ServiceAdvisoryBuilder o = (ServiceAdvisory.ServiceAdvisoryBuilder) other;
			
			merger.mergeRosetta(getCategory(), o.getCategory(), this::setCategory);
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			merger.mergeBasic(getEffectiveFrom(), o.getEffectiveFrom(), this::setEffectiveFrom);
			merger.mergeBasic(getEffectiveTo(), o.getEffectiveTo(), this::setEffectiveTo);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ServiceAdvisory _that = getType().cast(o);
		
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(effectiveFrom, _that.getEffectiveFrom())) return false;
			if (!Objects.equals(effectiveTo, _that.getEffectiveTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (effectiveFrom != null ? effectiveFrom.hashCode() : 0);
			_result = 31 * _result + (effectiveTo != null ? effectiveTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ServiceAdvisoryBuilder {" +
				"category=" + this.category + ", " +
				"description=" + this.description + ", " +
				"effectiveFrom=" + this.effectiveFrom + ", " +
				"effectiveTo=" + this.effectiveTo +
			'}';
		}
	}
}
