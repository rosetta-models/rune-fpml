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
import fpml.confirmation.ClearingRequirements;
import fpml.confirmation.ClearingRequirements.ClearingRequirementsBuilder;
import fpml.confirmation.ClearingRequirements.ClearingRequirementsBuilderImpl;
import fpml.confirmation.ClearingRequirements.ClearingRequirementsImpl;
import fpml.confirmation.Reason;
import fpml.confirmation.SupervisoryBody;
import fpml.confirmation.meta.ClearingRequirementsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingRequirements", builder=ClearingRequirements.ClearingRequirementsBuilderImpl.class, version="${project.version}")
public interface ClearingRequirements extends RosettaModelObject {

	ClearingRequirementsMeta metaData = new ClearingRequirementsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The regulator or other supervisory body to which the clearing requirements apply.
	 */
	SupervisoryBody getSupervisoryBody();
	/**
	 * Whether the particular trade type in question is required by this regulator to be cleared.
	 */
	Boolean getMandatorilyClearable();
	/**
	 * Indicates a reason supporting why the trade is mandatorily clearable or not.
	 */
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	ClearingRequirements build();
	
	ClearingRequirements.ClearingRequirementsBuilder toBuilder();
	
	static ClearingRequirements.ClearingRequirementsBuilder builder() {
		return new ClearingRequirements.ClearingRequirementsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingRequirements> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingRequirements> getType() {
		return ClearingRequirements.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.class, getSupervisoryBody());
		processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingRequirementsBuilder extends ClearingRequirements, RosettaModelObjectBuilder {
		SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody();
		SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		ClearingRequirements.ClearingRequirementsBuilder setSupervisoryBody(SupervisoryBody supervisoryBody);
		ClearingRequirements.ClearingRequirementsBuilder setMandatorilyClearable(Boolean mandatorilyClearable);
		ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason0);
		ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason1, int _idx);
		ClearingRequirements.ClearingRequirementsBuilder addReason(List<? extends Reason> reason2);
		ClearingRequirements.ClearingRequirementsBuilder setReason(List<? extends Reason> reason3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.SupervisoryBodyBuilder.class, getSupervisoryBody());
			processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		ClearingRequirements.ClearingRequirementsBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingRequirements  ***********************/
	class ClearingRequirementsImpl implements ClearingRequirements {
		private final SupervisoryBody supervisoryBody;
		private final Boolean mandatorilyClearable;
		private final List<? extends Reason> reason;
		
		protected ClearingRequirementsImpl(ClearingRequirements.ClearingRequirementsBuilder builder) {
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.mandatorilyClearable = builder.getMandatorilyClearable();
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		public SupervisoryBody getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public ClearingRequirements build() {
			return this;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder toBuilder() {
			ClearingRequirements.ClearingRequirementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingRequirements.ClearingRequirementsBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingRequirements _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRequirements {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reason=" + this.reason +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingRequirements  ***********************/
	class ClearingRequirementsBuilderImpl implements ClearingRequirements.ClearingRequirementsBuilder {
	
		protected SupervisoryBody.SupervisoryBodyBuilder supervisoryBody;
		protected Boolean mandatorilyClearable;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
	
		public ClearingRequirementsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("supervisoryBody")
		public SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody() {
			SupervisoryBody.SupervisoryBodyBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = SupervisoryBody.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			Reason.ReasonBuilder result;
			return getIndex(reason, _index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		public ClearingRequirements.ClearingRequirementsBuilder setSupervisoryBody(SupervisoryBody supervisoryBody) {
			this.supervisoryBody = supervisoryBody==null?null:supervisoryBody.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mandatorilyClearable")
		public ClearingRequirements.ClearingRequirementsBuilder setMandatorilyClearable(Boolean mandatorilyClearable) {
			this.mandatorilyClearable = mandatorilyClearable==null?null:mandatorilyClearable;
			return this;
		}
		@Override
		@RosettaAttribute("reason")
		public ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public ClearingRequirements.ClearingRequirementsBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ClearingRequirements.ClearingRequirementsBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ClearingRequirements build() {
			return new ClearingRequirements.ClearingRequirementsImpl(this);
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder prune() {
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null && getSupervisoryBody().hasData()) return true;
			if (getMandatorilyClearable()!=null) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingRequirements.ClearingRequirementsBuilder o = (ClearingRequirements.ClearingRequirementsBuilder) other;
			
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			merger.mergeBasic(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingRequirements _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRequirementsBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reason=" + this.reason +
			'}';
		}
	}
}
