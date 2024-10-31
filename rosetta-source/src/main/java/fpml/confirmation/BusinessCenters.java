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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.BusinessCenters.BusinessCentersBuilder;
import fpml.confirmation.BusinessCenters.BusinessCentersBuilderImpl;
import fpml.confirmation.BusinessCenters.BusinessCentersImpl;
import fpml.confirmation.meta.BusinessCentersMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type for defining business day calendar used in determining whether a day is a business day or not. A list of business day calendar locations may be ordered in the document alphabetically based on business day calendar location code. An FpML document containing an unordered business day calendar location list is still regarded as a conformant document.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessCenters", builder=BusinessCenters.BusinessCentersBuilderImpl.class, version="${project.version}")
public interface BusinessCenters extends RosettaModelObject {

	BusinessCentersMeta metaData = new BusinessCentersMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends BusinessCenter> getBusinessCenter();
	String getId();

	/*********************** Build Methods  ***********************/
	BusinessCenters build();
	
	BusinessCenters.BusinessCentersBuilder toBuilder();
	
	static BusinessCenters.BusinessCentersBuilder builder() {
		return new BusinessCenters.BusinessCentersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCenters> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessCenters> getType() {
		return BusinessCenters.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCentersBuilder extends BusinessCenters, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter(int _index);
		List<? extends BusinessCenter.BusinessCenterBuilder> getBusinessCenter();
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter0);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter1, int _idx);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends BusinessCenter> businessCenter2);
		BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends BusinessCenter> businessCenter3);
		BusinessCenters.BusinessCentersBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessCenters.BusinessCentersBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCenters  ***********************/
	class BusinessCentersImpl implements BusinessCenters {
		private final List<? extends BusinessCenter> businessCenter;
		private final String id;
		
		protected BusinessCentersImpl(BusinessCenters.BusinessCentersBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public List<? extends BusinessCenter> getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessCenters build() {
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			BusinessCenters.BusinessCentersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenters.BusinessCentersBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenters {" +
				"businessCenter=" + this.businessCenter + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCenters  ***********************/
	class BusinessCentersBuilderImpl implements BusinessCenters.BusinessCentersBuilder {
	
		protected List<BusinessCenter.BusinessCenterBuilder> businessCenter = new ArrayList<>();
		protected String id;
	
		public BusinessCentersBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessCenter")
		public List<? extends BusinessCenter.BusinessCenterBuilder> getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter(int _index) {
		
			if (businessCenter==null) {
				this.businessCenter = new ArrayList<>();
			}
			BusinessCenter.BusinessCenterBuilder result;
			return getIndex(businessCenter, _index, () -> {
						BusinessCenter.BusinessCenterBuilder newBusinessCenter = BusinessCenter.builder();
						return newBusinessCenter;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter) {
			if (businessCenter!=null) this.businessCenter.add(businessCenter.toBuilder());
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter, int _idx) {
			getIndex(this.businessCenter, _idx, () -> businessCenter.toBuilder());
			return this;
		}
		@Override 
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends BusinessCenter> businessCenters) {
			if (businessCenters != null) {
				for (BusinessCenter toAdd : businessCenters) {
					this.businessCenter.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends BusinessCenter> businessCenters) {
			if (businessCenters == null)  {
				this.businessCenter = new ArrayList<>();
			}
			else {
				this.businessCenter = businessCenters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public BusinessCenters.BusinessCentersBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BusinessCenters build() {
			return new BusinessCenters.BusinessCentersImpl(this);
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder prune() {
			businessCenter = businessCenter.stream().filter(b->b!=null).<BusinessCenter.BusinessCenterBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null && getBusinessCenter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenters.BusinessCentersBuilder o = (BusinessCenters.BusinessCentersBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::getOrCreateBusinessCenter);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCentersBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
