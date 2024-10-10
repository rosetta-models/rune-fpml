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
import fpml.confirmation.Approval;
import fpml.confirmation.Approvals;
import fpml.confirmation.Approvals.ApprovalsBuilder;
import fpml.confirmation.Approvals.ApprovalsBuilderImpl;
import fpml.confirmation.Approvals.ApprovalsImpl;
import fpml.confirmation.meta.ApprovalsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Approvals", builder=Approvals.ApprovalsBuilderImpl.class, version="${project.version}")
public interface Approvals extends RosettaModelObject {

	ApprovalsMeta metaData = new ApprovalsMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends Approval> getApproval();

	/*********************** Build Methods  ***********************/
	Approvals build();
	
	Approvals.ApprovalsBuilder toBuilder();
	
	static Approvals.ApprovalsBuilder builder() {
		return new Approvals.ApprovalsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Approvals> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Approvals> getType() {
		return Approvals.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("approval"), processor, Approval.class, getApproval());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalsBuilder extends Approvals, RosettaModelObjectBuilder {
		Approval.ApprovalBuilder getOrCreateApproval(int _index);
		List<? extends Approval.ApprovalBuilder> getApproval();
		Approvals.ApprovalsBuilder addApproval(Approval approval0);
		Approvals.ApprovalsBuilder addApproval(Approval approval1, int _idx);
		Approvals.ApprovalsBuilder addApproval(List<? extends Approval> approval2);
		Approvals.ApprovalsBuilder setApproval(List<? extends Approval> approval3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("approval"), processor, Approval.ApprovalBuilder.class, getApproval());
		}
		

		Approvals.ApprovalsBuilder prune();
	}

	/*********************** Immutable Implementation of Approvals  ***********************/
	class ApprovalsImpl implements Approvals {
		private final List<? extends Approval> approval;
		
		protected ApprovalsImpl(Approvals.ApprovalsBuilder builder) {
			this.approval = ofNullable(builder.getApproval()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("approval")
		public List<? extends Approval> getApproval() {
			return approval;
		}
		
		@Override
		public Approvals build() {
			return this;
		}
		
		@Override
		public Approvals.ApprovalsBuilder toBuilder() {
			Approvals.ApprovalsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Approvals.ApprovalsBuilder builder) {
			ofNullable(getApproval()).ifPresent(builder::setApproval);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approvals _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Approvals {" +
				"approval=" + this.approval +
			'}';
		}
	}

	/*********************** Builder Implementation of Approvals  ***********************/
	class ApprovalsBuilderImpl implements Approvals.ApprovalsBuilder {
	
		protected List<Approval.ApprovalBuilder> approval = new ArrayList<>();
	
		public ApprovalsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("approval")
		public List<? extends Approval.ApprovalBuilder> getApproval() {
			return approval;
		}
		
		public Approval.ApprovalBuilder getOrCreateApproval(int _index) {
		
			if (approval==null) {
				this.approval = new ArrayList<>();
			}
			Approval.ApprovalBuilder result;
			return getIndex(approval, _index, () -> {
						Approval.ApprovalBuilder newApproval = Approval.builder();
						return newApproval;
					});
		}
		
		@Override
		public Approvals.ApprovalsBuilder addApproval(Approval approval) {
			if (approval!=null) this.approval.add(approval.toBuilder());
			return this;
		}
		
		@Override
		public Approvals.ApprovalsBuilder addApproval(Approval approval, int _idx) {
			getIndex(this.approval, _idx, () -> approval.toBuilder());
			return this;
		}
		@Override 
		public Approvals.ApprovalsBuilder addApproval(List<? extends Approval> approvals) {
			if (approvals != null) {
				for (Approval toAdd : approvals) {
					this.approval.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("approval")
		public Approvals.ApprovalsBuilder setApproval(List<? extends Approval> approvals) {
			if (approvals == null)  {
				this.approval = new ArrayList<>();
			}
			else {
				this.approval = approvals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Approvals build() {
			return new Approvals.ApprovalsImpl(this);
		}
		
		@Override
		public Approvals.ApprovalsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approvals.ApprovalsBuilder prune() {
			approval = approval.stream().filter(b->b!=null).<Approval.ApprovalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApproval()!=null && getApproval().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approvals.ApprovalsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Approvals.ApprovalsBuilder o = (Approvals.ApprovalsBuilder) other;
			
			merger.mergeRosetta(getApproval(), o.getApproval(), this::getOrCreateApproval);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approvals _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalsBuilder {" +
				"approval=" + this.approval +
			'}';
		}
	}
}
