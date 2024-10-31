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
import fpml.confirmation.AccountReference;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OnBehalfOf.OnBehalfOfBuilder;
import fpml.confirmation.OnBehalfOf.OnBehalfOfBuilderImpl;
import fpml.confirmation.OnBehalfOf.OnBehalfOfImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.OnBehalfOfMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OnBehalfOf", builder=OnBehalfOf.OnBehalfOfBuilderImpl.class, version="${project.version}")
public interface OnBehalfOf extends RosettaModelObject {

	OnBehalfOfMeta metaData = new OnBehalfOfMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party for which the message reciever should work.
	 */
	PartyReference getPartyReference();
	/**
	 * Identifies the account(s) related to the party when they cannot be determined from the party alone, for example in a inter-book trade.
	 */
	List<? extends AccountReference> getAccountReference();

	/*********************** Build Methods  ***********************/
	OnBehalfOf build();
	
	OnBehalfOf.OnBehalfOfBuilder toBuilder();
	
	static OnBehalfOf.OnBehalfOfBuilder builder() {
		return new OnBehalfOf.OnBehalfOfBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OnBehalfOf> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OnBehalfOf> getType() {
		return OnBehalfOf.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OnBehalfOfBuilder extends OnBehalfOf, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference(int _index);
		List<? extends AccountReference.AccountReferenceBuilder> getAccountReference();
		OnBehalfOf.OnBehalfOfBuilder setPartyReference(PartyReference partyReference);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference0);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference1, int _idx);
		OnBehalfOf.OnBehalfOfBuilder addAccountReference(List<? extends AccountReference> accountReference2);
		OnBehalfOf.OnBehalfOfBuilder setAccountReference(List<? extends AccountReference> accountReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
		}
		

		OnBehalfOf.OnBehalfOfBuilder prune();
	}

	/*********************** Immutable Implementation of OnBehalfOf  ***********************/
	class OnBehalfOfImpl implements OnBehalfOf {
		private final PartyReference partyReference;
		private final List<? extends AccountReference> accountReference;
		
		protected OnBehalfOfImpl(OnBehalfOf.OnBehalfOfBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		public List<? extends AccountReference> getAccountReference() {
			return accountReference;
		}
		
		@Override
		public OnBehalfOf build() {
			return this;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder toBuilder() {
			OnBehalfOf.OnBehalfOfBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OnBehalfOf.OnBehalfOfBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOf _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOf {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of OnBehalfOf  ***********************/
	class OnBehalfOfBuilderImpl implements OnBehalfOf.OnBehalfOfBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<AccountReference.AccountReferenceBuilder> accountReference = new ArrayList<>();
	
		public OnBehalfOfBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		public List<? extends AccountReference.AccountReferenceBuilder> getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference(int _index) {
		
			if (accountReference==null) {
				this.accountReference = new ArrayList<>();
			}
			AccountReference.AccountReferenceBuilder result;
			return getIndex(accountReference, _index, () -> {
						AccountReference.AccountReferenceBuilder newAccountReference = AccountReference.builder();
						return newAccountReference;
					});
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public OnBehalfOf.OnBehalfOfBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accountReference")
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference) {
			if (accountReference!=null) this.accountReference.add(accountReference.toBuilder());
			return this;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(AccountReference accountReference, int _idx) {
			getIndex(this.accountReference, _idx, () -> accountReference.toBuilder());
			return this;
		}
		@Override 
		public OnBehalfOf.OnBehalfOfBuilder addAccountReference(List<? extends AccountReference> accountReferences) {
			if (accountReferences != null) {
				for (AccountReference toAdd : accountReferences) {
					this.accountReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OnBehalfOf.OnBehalfOfBuilder setAccountReference(List<? extends AccountReference> accountReferences) {
			if (accountReferences == null)  {
				this.accountReference = new ArrayList<>();
			}
			else {
				this.accountReference = accountReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public OnBehalfOf build() {
			return new OnBehalfOf.OnBehalfOfImpl(this);
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			accountReference = accountReference.stream().filter(b->b!=null).<AccountReference.AccountReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOf.OnBehalfOfBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OnBehalfOf.OnBehalfOfBuilder o = (OnBehalfOf.OnBehalfOfBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::getOrCreateAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOf _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOfBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}
}
