package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InformationProvider;
import fpml.confirmation.validation.InformationProviderTypeFormatValidator;
import fpml.confirmation.validation.InformationProviderValidator;
import fpml.confirmation.validation.exists.InformationProviderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InformationProvider.class)
public class InformationProviderMeta implements RosettaMetaData<InformationProvider> {

	@Override
	public List<Validator<? super InformationProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InformationProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InformationProvider> validator() {
		return new InformationProviderValidator();
	}

	@Override
	public Validator<? super InformationProvider> typeFormatValidator() {
		return new InformationProviderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InformationProvider, Set<String>> onlyExistsValidator() {
		return new InformationProviderOnlyExistsValidator();
	}
}
