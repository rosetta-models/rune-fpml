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
import fpml.confirmation.StreetAddress;
import fpml.confirmation.StreetAddress.StreetAddressBuilder;
import fpml.confirmation.StreetAddress.StreetAddressBuilderImpl;
import fpml.confirmation.StreetAddress.StreetAddressImpl;
import fpml.confirmation.meta.StreetAddressMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type that describes the set of street and building number information that identifies a postal address within a city.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="StreetAddress", builder=StreetAddress.StreetAddressBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface StreetAddress extends RosettaModelObject {

	StreetAddressMeta metaData = new StreetAddressMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An individual line of street and building number information, forming part of a postal address.
	 */
	List<String> getStreetLine();

	/*********************** Build Methods  ***********************/
	StreetAddress build();
	
	StreetAddress.StreetAddressBuilder toBuilder();
	
	static StreetAddress.StreetAddressBuilder builder() {
		return new StreetAddress.StreetAddressBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StreetAddress> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StreetAddress> getType() {
		return StreetAddress.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("streetLine"), String.class, getStreetLine(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StreetAddressBuilder extends StreetAddress, RosettaModelObjectBuilder {
		StreetAddress.StreetAddressBuilder addStreetLine(String streetLine0);
		StreetAddress.StreetAddressBuilder addStreetLine(String streetLine1, int _idx);
		StreetAddress.StreetAddressBuilder addStreetLine(List<String> streetLine2);
		StreetAddress.StreetAddressBuilder setStreetLine(List<String> streetLine3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("streetLine"), String.class, getStreetLine(), this);
		}
		

		StreetAddress.StreetAddressBuilder prune();
	}

	/*********************** Immutable Implementation of StreetAddress  ***********************/
	class StreetAddressImpl implements StreetAddress {
		private final List<String> streetLine;
		
		protected StreetAddressImpl(StreetAddress.StreetAddressBuilder builder) {
			this.streetLine = ofNullable(builder.getStreetLine()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("streetLine")
		public List<String> getStreetLine() {
			return streetLine;
		}
		
		@Override
		public StreetAddress build() {
			return this;
		}
		
		@Override
		public StreetAddress.StreetAddressBuilder toBuilder() {
			StreetAddress.StreetAddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StreetAddress.StreetAddressBuilder builder) {
			ofNullable(getStreetLine()).ifPresent(builder::setStreetLine);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StreetAddress _that = getType().cast(o);
		
			if (!ListEquals.listEquals(streetLine, _that.getStreetLine())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (streetLine != null ? streetLine.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StreetAddress {" +
				"streetLine=" + this.streetLine +
			'}';
		}
	}

	/*********************** Builder Implementation of StreetAddress  ***********************/
	class StreetAddressBuilderImpl implements StreetAddress.StreetAddressBuilder {
	
		protected List<String> streetLine = new ArrayList<>();
	
		public StreetAddressBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("streetLine")
		public List<String> getStreetLine() {
			return streetLine;
		}
		
		@Override
		@RosettaAttribute("streetLine")
		public StreetAddress.StreetAddressBuilder addStreetLine(String streetLine) {
			if (streetLine!=null) this.streetLine.add(streetLine);
			return this;
		}
		
		@Override
		public StreetAddress.StreetAddressBuilder addStreetLine(String streetLine, int _idx) {
			getIndex(this.streetLine, _idx, () -> streetLine);
			return this;
		}
		@Override 
		public StreetAddress.StreetAddressBuilder addStreetLine(List<String> streetLines) {
			if (streetLines != null) {
				for (String toAdd : streetLines) {
					this.streetLine.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public StreetAddress.StreetAddressBuilder setStreetLine(List<String> streetLines) {
			if (streetLines == null)  {
				this.streetLine = new ArrayList<>();
			}
			else {
				this.streetLine = streetLines.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public StreetAddress build() {
			return new StreetAddress.StreetAddressImpl(this);
		}
		
		@Override
		public StreetAddress.StreetAddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StreetAddress.StreetAddressBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStreetLine()!=null && !getStreetLine().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StreetAddress.StreetAddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StreetAddress.StreetAddressBuilder o = (StreetAddress.StreetAddressBuilder) other;
			
			
			merger.mergeBasic(getStreetLine(), o.getStreetLine(), (Consumer<String>) this::addStreetLine);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StreetAddress _that = getType().cast(o);
		
			if (!ListEquals.listEquals(streetLine, _that.getStreetLine())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (streetLine != null ? streetLine.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StreetAddressBuilder {" +
				"streetLine=" + this.streetLine +
			'}';
		}
	}
}
