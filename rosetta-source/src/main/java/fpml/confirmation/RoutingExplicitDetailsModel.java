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
import fpml.confirmation.Address;
import fpml.confirmation.RoutingExplicitDetailsModel;
import fpml.confirmation.RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder;
import fpml.confirmation.RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilderImpl;
import fpml.confirmation.RoutingExplicitDetailsModel.RoutingExplicitDetailsModelImpl;
import fpml.confirmation.meta.RoutingExplicitDetailsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RoutingExplicitDetailsModel", builder=RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilderImpl.class, version="${project.version}")
public interface RoutingExplicitDetailsModel extends RosettaModelObject {

	RoutingExplicitDetailsModelMeta metaData = new RoutingExplicitDetailsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A real name that is used to identify a party involved in the routing of a payment.
	 */
	String getRoutingName();
	/**
	 * A physical postal address via which a payment can be routed.
	 */
	Address getRoutingAddress();
	/**
	 * An account number via which a payment can be routed.
	 */
	String getRoutingAccountNumber();
	/**
	 * A piece of free-format text used to assist the identification of a party involved in the routing of a payment.
	 */
	List<String> getRoutingReferenceText();

	/*********************** Build Methods  ***********************/
	RoutingExplicitDetailsModel build();
	
	RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder toBuilder();
	
	static RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder builder() {
		return new RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingExplicitDetailsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingExplicitDetailsModel> getType() {
		return RoutingExplicitDetailsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
		processRosetta(path.newSubPath("routingAddress"), processor, Address.class, getRoutingAddress());
		processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
		processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingExplicitDetailsModelBuilder extends RoutingExplicitDetailsModel, RosettaModelObjectBuilder {
		Address.AddressBuilder getOrCreateRoutingAddress();
		Address.AddressBuilder getRoutingAddress();
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingName(String routingName);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingAddress(Address routingAddress);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingAccountNumber(String routingAccountNumber);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(String routingReferenceText0);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(String routingReferenceText1, int _idx);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(List<String> routingReferenceText2);
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingReferenceText(List<String> routingReferenceText3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("routingName"), String.class, getRoutingName(), this);
			processRosetta(path.newSubPath("routingAddress"), processor, Address.AddressBuilder.class, getRoutingAddress());
			processor.processBasic(path.newSubPath("routingAccountNumber"), String.class, getRoutingAccountNumber(), this);
			processor.processBasic(path.newSubPath("routingReferenceText"), String.class, getRoutingReferenceText(), this);
		}
		

		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingExplicitDetailsModel  ***********************/
	class RoutingExplicitDetailsModelImpl implements RoutingExplicitDetailsModel {
		private final String routingName;
		private final Address routingAddress;
		private final String routingAccountNumber;
		private final List<String> routingReferenceText;
		
		protected RoutingExplicitDetailsModelImpl(RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder builder) {
			this.routingName = builder.getRoutingName();
			this.routingAddress = ofNullable(builder.getRoutingAddress()).map(f->f.build()).orElse(null);
			this.routingAccountNumber = builder.getRoutingAccountNumber();
			this.routingReferenceText = ofNullable(builder.getRoutingReferenceText()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingName")
		public String getRoutingName() {
			return routingName;
		}
		
		@Override
		@RosettaAttribute("routingAddress")
		public Address getRoutingAddress() {
			return routingAddress;
		}
		
		@Override
		@RosettaAttribute("routingAccountNumber")
		public String getRoutingAccountNumber() {
			return routingAccountNumber;
		}
		
		@Override
		@RosettaAttribute("routingReferenceText")
		public List<String> getRoutingReferenceText() {
			return routingReferenceText;
		}
		
		@Override
		public RoutingExplicitDetailsModel build() {
			return this;
		}
		
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder toBuilder() {
			RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder builder) {
			ofNullable(getRoutingName()).ifPresent(builder::setRoutingName);
			ofNullable(getRoutingAddress()).ifPresent(builder::setRoutingAddress);
			ofNullable(getRoutingAccountNumber()).ifPresent(builder::setRoutingAccountNumber);
			ofNullable(getRoutingReferenceText()).ifPresent(builder::setRoutingReferenceText);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingExplicitDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetailsModel {" +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingExplicitDetailsModel  ***********************/
	class RoutingExplicitDetailsModelBuilderImpl implements RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder {
	
		protected String routingName;
		protected Address.AddressBuilder routingAddress;
		protected String routingAccountNumber;
		protected List<String> routingReferenceText = new ArrayList<>();
	
		public RoutingExplicitDetailsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingName")
		public String getRoutingName() {
			return routingName;
		}
		
		@Override
		@RosettaAttribute("routingAddress")
		public Address.AddressBuilder getRoutingAddress() {
			return routingAddress;
		}
		
		@Override
		public Address.AddressBuilder getOrCreateRoutingAddress() {
			Address.AddressBuilder result;
			if (routingAddress!=null) {
				result = routingAddress;
			}
			else {
				result = routingAddress = Address.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingAccountNumber")
		public String getRoutingAccountNumber() {
			return routingAccountNumber;
		}
		
		@Override
		@RosettaAttribute("routingReferenceText")
		public List<String> getRoutingReferenceText() {
			return routingReferenceText;
		}
		
		@Override
		@RosettaAttribute("routingName")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingName(String routingName) {
			this.routingName = routingName==null?null:routingName;
			return this;
		}
		@Override
		@RosettaAttribute("routingAddress")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingAddress(Address routingAddress) {
			this.routingAddress = routingAddress==null?null:routingAddress.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("routingAccountNumber")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingAccountNumber(String routingAccountNumber) {
			this.routingAccountNumber = routingAccountNumber==null?null:routingAccountNumber;
			return this;
		}
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(String routingReferenceText) {
			if (routingReferenceText!=null) this.routingReferenceText.add(routingReferenceText);
			return this;
		}
		
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(String routingReferenceText, int _idx) {
			getIndex(this.routingReferenceText, _idx, () -> routingReferenceText);
			return this;
		}
		@Override 
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder addRoutingReferenceText(List<String> routingReferenceTexts) {
			if (routingReferenceTexts != null) {
				for (String toAdd : routingReferenceTexts) {
					this.routingReferenceText.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("routingReferenceText")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder setRoutingReferenceText(List<String> routingReferenceTexts) {
			if (routingReferenceTexts == null)  {
				this.routingReferenceText = new ArrayList<>();
			}
			else {
				this.routingReferenceText = routingReferenceTexts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public RoutingExplicitDetailsModel build() {
			return new RoutingExplicitDetailsModel.RoutingExplicitDetailsModelImpl(this);
		}
		
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder prune() {
			if (routingAddress!=null && !routingAddress.prune().hasData()) routingAddress = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingName()!=null) return true;
			if (getRoutingAddress()!=null && getRoutingAddress().hasData()) return true;
			if (getRoutingAccountNumber()!=null) return true;
			if (getRoutingReferenceText()!=null && !getRoutingReferenceText().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder o = (RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder) other;
			
			merger.mergeRosetta(getRoutingAddress(), o.getRoutingAddress(), this::setRoutingAddress);
			
			merger.mergeBasic(getRoutingName(), o.getRoutingName(), this::setRoutingName);
			merger.mergeBasic(getRoutingAccountNumber(), o.getRoutingAccountNumber(), this::setRoutingAccountNumber);
			merger.mergeBasic(getRoutingReferenceText(), o.getRoutingReferenceText(), (Consumer<String>) this::addRoutingReferenceText);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingExplicitDetailsModel _that = getType().cast(o);
		
			if (!Objects.equals(routingName, _that.getRoutingName())) return false;
			if (!Objects.equals(routingAddress, _that.getRoutingAddress())) return false;
			if (!Objects.equals(routingAccountNumber, _that.getRoutingAccountNumber())) return false;
			if (!ListEquals.listEquals(routingReferenceText, _that.getRoutingReferenceText())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingName != null ? routingName.hashCode() : 0);
			_result = 31 * _result + (routingAddress != null ? routingAddress.hashCode() : 0);
			_result = 31 * _result + (routingAccountNumber != null ? routingAccountNumber.hashCode() : 0);
			_result = 31 * _result + (routingReferenceText != null ? routingReferenceText.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetailsModelBuilder {" +
				"routingName=" + this.routingName + ", " +
				"routingAddress=" + this.routingAddress + ", " +
				"routingAccountNumber=" + this.routingAccountNumber + ", " +
				"routingReferenceText=" + this.routingReferenceText +
			'}';
		}
	}
}
